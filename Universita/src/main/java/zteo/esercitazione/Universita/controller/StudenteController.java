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


    @PostMapping("/add")
    public ResponseEntity<StudenteDto> addStudente(@RequestBody @Valid StudenteDto studenteDto)
    {
        return new ResponseEntity<>(studenteService.addStudente(studenteDto), HttpStatus.CREATED);
    }

    @GetMapping("/getMatricola/{matricola}")
    public ResponseEntity<StudenteDto> getStudenteByMatricola(@PathVariable String matricola)
    {
        return new ResponseEntity<>(studenteService.getStudenteByMatricola(matricola), HttpStatus.OK);
    }

    @PutMapping("/updateStudente/{matricola}")
    public ResponseEntity<StudenteDto> updateStudente(@PathVariable String matricola, @RequestBody @Valid StudenteDto studenteDto)
    {
        return new ResponseEntity<>(studenteService.updateStudente(studenteDto, matricola), HttpStatus.OK);
    }

//    @DeleteMapping("/deleteStudente/{matricola}")
//    public ResponseEntity<Void> deleteByMatricola(@PathVariable String matricola)
//    {
//       studenteService.deleteByMatricola(matricola);
//       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }

    @DeleteMapping("/deleteStudente/{matricola}")
    public ResponseEntity<Void> eliminaStudentePerMatricola(@PathVariable String matricola) {
        studenteService.eliminaStudentePerMatricola(matricola);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
