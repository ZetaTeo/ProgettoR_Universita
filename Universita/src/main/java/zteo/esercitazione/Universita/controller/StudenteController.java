package zteo.esercitazione.Universita.controller;


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
public class StudenteController {

    private final StudenteService studenteService;


    @PostMapping("/addStudente")
    public ResponseEntity<StudenteDto> createStudente(@Valid @RequestBody StudenteDto studenteDto)
    {
        //return ResponseEntity.ok(studenteService.createStudent(studenteDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(studenteService.createStudente(studenteDto));
    }

    @PatchMapping("/updateEmailStudente")
    public ResponseEntity<StudenteDto> updateEmailStudente(@RequestParam String matricola, @RequestBody @Valid Map<String, String> requestBody)
    {
        String nuovaEmail = requestBody.get("nuovaEmail");
        return ResponseEntity.ok(studenteService.updateEmailStudente(matricola, nuovaEmail));
    }

    @PatchMapping("/updateEmailAndMatricolaStudente")
    public ResponseEntity<StudenteDto> updateStudente(
            @RequestParam String matricolaAttuale,
            @RequestBody Map<String, String> requestBody)
    {
        return ResponseEntity.ok(studenteService.updateEmailAndMatricolaStudente(matricolaAttuale, requestBody));
    }



}
