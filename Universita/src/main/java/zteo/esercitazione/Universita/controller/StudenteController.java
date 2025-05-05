package zteo.esercitazione.Universita.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import zteo.esercitazione.Universita.dto.StatsStudenteDto;
import zteo.esercitazione.Universita.dto.StudenteDto;
import zteo.esercitazione.Universita.entity.Studente;
import zteo.esercitazione.Universita.service.StudenteService;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/studente")
public class StudenteController {

    private final StudenteService studenteService;


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
    @GetMapping("/getAllStudentsOfDepartment/{nomeDipartimento}")
    @Operation(summary = "Restituisce tutti gli studenti di un dipartimento",
            tags = "Operazioni - Studente")
    public ResponseEntity<List<StudenteDto>> getAllStudentsOfDepartment(@PathVariable String nomeDipartimento)
    {
        return ResponseEntity.ok(studenteService.getAllStudentsOfDepartment(nomeDipartimento));
    }


    @GetMapping("/getStats/{matricola}")
    @Operation(summary = "Restituisce le statistiche di uno studente",
            tags = "Operazioni - Studente")
    public ResponseEntity<StatsStudenteDto> getStudentStats(@PathVariable String matricola)
    {
        StatsStudenteDto stats = studenteService.getStudentStats(matricola);
        return ResponseEntity.ok(stats);
    }


}
