package zteo.esercitazione.Universita.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import zteo.esercitazione.Universita.dto.StudenteDto;
import zteo.esercitazione.Universita.service.StudenteService;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/studente")
public class StudenteController {

    private final StudenteService studenteService;


    @PostMapping("/addStudente")
    @Operation(summary = "Inserisce un nuovo studente",
            tags = "Operazioni - Studente")
    public ResponseEntity<StudenteDto> createStudente(@RequestBody StudenteDto studenteDto)
    {
        //return ResponseEntity.ok(studenteService.createStudent(studenteDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(studenteService.createStudente(studenteDto));
    }


    @PatchMapping("/updateEmailStudente")
    @Operation(summary = "Aggiorna solo l'email di uno studente",
            tags = "Operazioni - Studente")
    public ResponseEntity<StudenteDto> updateEmailStudente(@RequestParam String matricola, @RequestBody StudenteDto studenteDto)
    {
        studenteDto = studenteService.updateEmailStudente(matricola, studenteDto.getEmail());
        return ResponseEntity.ok(studenteDto);
    }

//    @PatchMapping("/updateEmailAndMatricolaStudente")
//    @Operation(summary = "Aggiorna l'email e la matricola di uno studente",
//               tags = "Operazioni - Studente")
//    public ResponseEntity<StudenteDto> updateEmailAndMatricolaStudente(
//            @RequestParam String matricolaAttuale,
//            @RequestBody StudenteDto studenteDto)
//    {
//        return ResponseEntity.ok(studenteService.updateEmailAndMatricolaStudente(matricolaAttuale, studenteDto.getMatricola(), studenteDto.getEmail()));
//    }


    @PatchMapping("/updateEmailOrMatricola")
    @Operation(summary = "Aggiorna l'email e/o la matricola di uno studente",
            description = "Aggiorna l'email, la matricola o entrambi in un'unica operazione, a seconda dei dati passati.",
            tags = "Operazioni - Studente")
    public ResponseEntity<StudenteDto> updateEmailOrMatricola(
            @RequestParam String matricolaAttuale,  // Parametro obbligatorio per identificare lo studente
            @RequestBody StudenteDto studenteDto)   // Corpo della richiesta che può contenere email o matricola
    {
        // Chiamata al service per aggiornare email e/o matricola
        StudenteDto updatedStudente = studenteService.updateEmailAndMatricolaStudente(
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

}
