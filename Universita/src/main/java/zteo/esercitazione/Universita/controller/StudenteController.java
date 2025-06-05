package zteo.esercitazione.Universita.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import zteo.esercitazione.Universita.dto.StatsStudenteDto;
import zteo.esercitazione.Universita.dto.StudenteDto;
import zteo.esercitazione.Universita.entity.Studente;
import zteo.esercitazione.Universita.repository.StudenteRepository;
import zteo.esercitazione.Universita.service.StudenteService;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/studente")
public class StudenteController {

    private final StudenteService studenteService;
    private final StudenteRepository studenteRepository;


    @PostMapping("/addStudente")
    @Operation(summary = "Inserisce un nuovo studente",
               tags = "Operazioni - Studente")
    public ResponseEntity<StudenteDto> createStudente(@RequestBody @Valid StudenteDto studenteDto)
    {
        //return ResponseEntity.ok(studenteService.createStudent(studenteDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(studenteService.createStudente(studenteDto));
    }


    @PatchMapping("/updateEmailOrMatricola")
    @Operation(summary = "Aggiorna l'email e/o la matricola di uno studente",
               tags = "Operazioni - Studente")
    public ResponseEntity<StudenteDto> updateEmailOrMatricola(
            @RequestParam String matricolaAttuale,
            @RequestBody StudenteDto studenteDto)
    {

        StudenteDto updatedStudente = studenteService.updateEmailOrMatricolaStudente(
                matricolaAttuale,
                studenteDto.getMatricola(),
                studenteDto.getEmail()
        );

        return ResponseEntity.ok(updatedStudente);
    }


    @DeleteMapping("/deleteStudente/{matricola}")
    @Operation(summary = "Elimina uno studente con la sua matricola",
            tags = "Operazioni - Studente")
    public ResponseEntity<String> deleteStudente(@PathVariable String matricola)
    {
        studenteService.deleteStudente(matricola);
        return ResponseEntity.ok("Studente con matricola " + matricola + " eliminato con successo.");
    }

    //vers dto
    @GetMapping("/getAllStudentsOfDepartment/{dipartimentoartimento}")
    @Operation(summary = "Restituisce tutti gli studenti di un dipartimento",
            tags = "Operazioni - Studente")
    public ResponseEntity<List<StudenteDto>> getAllStudentsOfDepartment(@PathVariable String dipartimentoartimento)
    {
        return ResponseEntity.ok(studenteService.getAllStudentsOfDepartment(dipartimentoartimento));
    }


    @GetMapping("/getStats/{matricola}")
    @Operation(summary = "Restituisce le statistiche di uno studente",
            tags = "Operazioni - Studente")
    public ResponseEntity<StatsStudenteDto> getStudentStats(@PathVariable String matricola)
    {
        StatsStudenteDto stats = studenteService.getStudentStats(matricola);
        return ResponseEntity.ok(stats);
    }

//**** Vecchio meteodo senza PageModel ****
//    @GetMapping("/metodoPageable")
//    @Operation(summary = "Prova pageable",
//            tags = "Operazioni - Studente")
//    public ResponseEntity<Page<StudenteDto>> getStudentiDipMedia
//            (
//            @RequestParam String dipartimento,
//            @RequestParam double media,
//            @PageableDefault(size = 15, sort = "cognome", direction = Sort.Direction.ASC) Pageable pageable
//            )
//    {
//        Page<StudenteDto> studenti = studenteService.getStudentiDipMedia(dipartimento, media, pageable);
//        return ResponseEntity.ok(studenti);
//    }

    @GetMapping("/metodoPageable")
    @Operation(summary = "Prova pageable",
            tags = "Operazioni - Studente")
    public ResponseEntity<PagedModel<EntityModel<StudenteDto>>> getStudentiDipMedia(
            @RequestParam String dipartimento,
            @RequestParam double media,
            @PageableDefault(size = 15, sort = "mediaAritmetica", direction = Sort.Direction.ASC) Pageable pageable,
            PagedResourcesAssembler<StudenteDto> assembler
    ) {
        Page<StudenteDto> studenti = studenteService.getStudentiDipMedia(dipartimento, media, pageable);

        // Trasformo la Page<StudenteDto> in un PagedModel<EntityModel<StudenteDto>>
        PagedModel<EntityModel<StudenteDto>> pagedModel = assembler.toModel(studenti,
                studenteDto -> EntityModel.of(studenteDto,
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(getClass())
                                        .getStudentiDipMedia(dipartimento, media, pageable, assembler))
                                .withSelfRel()
                ));

        return ResponseEntity.ok(pagedModel);
    }


}
