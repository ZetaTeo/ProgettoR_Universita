package zteo.esercitazione.Universita.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import zteo.esercitazione.Universita.dto.EsameDto;
import zteo.esercitazione.Universita.entity.Esame;
import zteo.esercitazione.Universita.service.EsameService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/esame")
public class EsameController {

    private final EsameService esameService;

    @PostMapping("/aggiungiEsame")
    public ResponseEntity<EsameDto> aggiungiEsame(@RequestBody EsameDto esameDto)
    {
        Esame nuovoEsame = esameService.aggiungiEsame(esameDto.getMateria(), esameDto.getMatricola(), esameDto.getVoto());
        return ResponseEntity.status(HttpStatus.CREATED).body(EsameDto.fromEntityToDto(nuovoEsame));
    }




//    public ResponseEntity<Esame> aggiungiEsame(@RequestParam String materia,
//                                               @RequestParam String matricola,
//                                               @RequestParam int voto){
//        Esame nuovoEsame = esameService.aggiungiEsame(materia, matricola, voto);
//        return ResponseEntity.status(HttpStatus.CREATED).body(nuovoEsame);
//    }

}
