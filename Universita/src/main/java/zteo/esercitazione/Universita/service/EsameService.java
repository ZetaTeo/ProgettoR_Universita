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
                .orElseThrow(() -> new ResourceNotFoundException("Studente con matricola " + matricola + " non trovato"));

        Materia materia = materiaRepository.findByNomeMateria(materiaEsame)
                .orElseThrow(() -> new ResourceNotFoundException("Materia " + materiaEsame + " non trovata"));


        boolean esiste = esameRepository.verificaAppartenenzaDipartimento(studente.getId(), materia.getId()) != 0;
        if(!esiste)
            throw new IllegalStateException("Studente e materia non appartengono allo stesso dipartimento");

        Esame esame = esameRepository.findByStudenteAndMateria(studente, materia).orElse(null);

        if (esame != null) {
            if (esame.getVoto() >= 18) throw new IllegalStateException("Esame già superato con " + esame.getVoto());
            if (esame.getData().isEqual(dataEsame)) throw new IllegalStateException("Esame già sostenuto nella stessa data");

            esame.setVoto(votoEsame);
            esame.setData(dataEsame);
            if (votoEsame < 18)
                esame.setBocciature(esame.getBocciature() + 1);

        } else {
            esame = new Esame(materia, studente, votoEsame, dataEsame, 0); 
            if (votoEsame < 18)
                esame.setBocciature(1);
        }

        if (votoEsame >= 18)
        {
            studente.setCfuTotali(studente.getCfuTotali() + materia.getCfu());
            studenteRepository.save(studente);
        }

        return esameRepository.save(esame);
    }

  

}
