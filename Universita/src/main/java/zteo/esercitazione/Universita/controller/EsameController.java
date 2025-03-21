package zteo.esercitazione.Universita.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import zteo.esercitazione.Universita.dto.EsameDto;
import zteo.esercitazione.Universita.entity.Esame;
import zteo.esercitazione.Universita.exception.ResourceNotFoundException;
import zteo.esercitazione.Universita.service.EsameService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/esame")
public class EsameController {

    private final EsameService esameService;



    @PostMapping("/aggiungiEsame")
    public ResponseEntity<EsameDto> aggiungiEsame(@RequestBody EsameDto esameDto) {
        Esame esame = esameService.aggiungiEsame(esameDto.getMateria(), esameDto.getMatricola(), esameDto.getVoto(), esameDto.getData());
        EsameDto esameResponse = EsameDto.fromEntityToDto(esame);
        return ResponseEntity.status(HttpStatus.CREATED).body(esameResponse);
    }

    @DeleteMapping("/rimuoviEsami")
    public ResponseEntity<String> rimuoviTuttiGliEsami(@RequestParam String matricola)
    {
        esameService.rimuoviTuttiGliEsami(matricola);
        return ResponseEntity.ok("Tutti gli esami dello studente con matricola " + matricola + " sono stati eliminati.");
    }



}
