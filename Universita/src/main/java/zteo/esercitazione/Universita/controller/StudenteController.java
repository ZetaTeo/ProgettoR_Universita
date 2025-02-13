package zteo.esercitazione.Universita.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zteo.esercitazione.Universita.dto.StudenteDto;
import zteo.esercitazione.Universita.entity.Studente;
import zteo.esercitazione.Universita.service.StudenteService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/studente")
public class StudenteController {

    private final StudenteService studenteService;






}
