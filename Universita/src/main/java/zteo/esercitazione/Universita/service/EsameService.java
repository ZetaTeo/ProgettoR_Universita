package zteo.esercitazione.Universita.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import zteo.esercitazione.Universita.dto.EsameDto;
import zteo.esercitazione.Universita.entity.Esame;
import zteo.esercitazione.Universita.entity.Materia;
import zteo.esercitazione.Universita.entity.Studente;
import zteo.esercitazione.Universita.exception.ResourceNotFoundException;
import zteo.esercitazione.Universita.repository.EsameRepository;
import zteo.esercitazione.Universita.repository.MateriaRepository;
import zteo.esercitazione.Universita.repository.StudenteRepository;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EsameService {

    private final EsameRepository esameRepository;
    private final StudenteRepository studenteRepository;
    private final MateriaRepository materiaRepository;


    public Esame aggiungiEsame(String materiaEsame, String matricola, int votoEsame, LocalDate dataEsame) {


        Studente studente = studenteRepository.findByMatricola(matricola)
                .orElseThrow(() -> new ResourceNotFoundException("Lo studente con matricola " + matricola + " non è stato trovato"));

        Materia materia = materiaRepository.findByNomeMateria(materiaEsame)
                .orElseThrow(() -> new ResourceNotFoundException("La materia " + materiaEsame + " non è stata trovata"));

        Optional<Esame> esameEsistente = esameRepository.findByStudenteAndMateria(studente, materia);

        Esame esame;

        if (esameEsistente.isPresent()) {
            esame = esameEsistente.get();

            if (esame.getVoto() >= 18) {
                throw new IllegalStateException("L'esame con voto " + esame.getVoto() + " non può essere modificato.");
            }


            if (esame.getData().isEqual(dataEsame)) {
                throw new IllegalStateException("Non puoi sostenere due esami della stessa materia lo stesso giorno.");
            }

            if (votoEsame < 18) {
                esame.setBocciature(esame.getBocciature() + 1);
            } else {

                studente.setCfuTotali(studente.getCfuTotali() + materia.getCfu());
                studenteRepository.save(studente);
            }

            esame.setVoto(votoEsame);
            esame.setData(dataEsame);

        } else {

            esame = new Esame(materia, studente, votoEsame, dataEsame, votoEsame < 18 ? 1 : 0);

            if (votoEsame >= 18) {
                studente.setCfuTotali(studente.getCfuTotali() + materia.getCfu());
                studenteRepository.save(studente);
            }
        }

        return esameRepository.save(esame);
    }



}
