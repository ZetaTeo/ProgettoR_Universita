package zteo.esercitazione.Universita.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import zteo.esercitazione.Universita.dto.StudenteDto;
import zteo.esercitazione.Universita.service.StudenteService;

@RestController
@RequiredArgsConstructor
public class StudenteController {

    private final StudenteService studenteService;


    @PostMapping("/addStudente")
    public ResponseEntity<StudenteDto> createStudente(@Valid @RequestBody StudenteDto studenteDto)
    {
        //return ResponseEntity.ok(studenteService.createStudent(studenteDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(studenteService.createStudent(studenteDto));
    }




}
