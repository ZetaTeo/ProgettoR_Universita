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



    public Esame aggiungiEsame(String materiaEsame, String matricola, int votoEsame) {
        // Recupera lo studente dalla matricola
        Studente studente = studenteRepository.findByMatricola(matricola)
                .orElseThrow(() -> new ResourceNotFoundException("Lo studente con matricola " + matricola + " non è stato trovato"));

        // Recupera la materia dal nome
        Materia materia = materiaRepository.findByNomeMateria(materiaEsame)
                .orElseThrow(() -> new ResourceNotFoundException("La materia " + materiaEsame + " non è stata trovata"));

        // Cerca un esame già registrato per quello studente e quella materia
        Optional<Esame> esameEsistente = esameRepository.findByStudenteAndMateria(studente, materia);

        Esame esame;

        if (esameEsistente.isPresent()) {
            // Se l'esame esiste, lo recuperiamo
            esame = esameEsistente.get();

            // Se il voto dell'esame esistente è maggiore o uguale a 18, blocchiamo la modifica
            if (esame.getVoto() >= 18) {
                throw new IllegalStateException("Non è possibile modificare l'esame perché il voto è già maggiore o uguale a 18.");
            }

            // Se il voto del nuovo esame è inferiore a 18, incrementiamo le bocciature
            if (votoEsame < 18) {
                esame.setBocciature(esame.getBocciature() + 1);
            } else {
                // Se il voto è maggiore o uguale a 18, aggiorniamo i CFU
                studente.setCfuTotali(studente.getCfuTotali() + materia.getCfu());
                studenteRepository.save(studente);
            }

            // Aggiorniamo il voto e la data
            esame.setVoto(votoEsame);
            esame.setData(LocalDate.now());

        } else {
            // Se non esiste, lo creiamo
            esame = new Esame();
            esame.setStudente(studente);
            esame.setMateria(materia);
            esame.setVoto(votoEsame);
            esame.setData(LocalDate.now());
            esame.setBocciature(votoEsame < 18 ? 1 : 0);

            // Se supera l'esame, aggiungiamo i CFU
            if (votoEsame >= 18) {
                studente.setCfuTotali(studente.getCfuTotali() + materia.getCfu());
                studenteRepository.save(studente);
            }
        }

        return esameRepository.save(esame);
    }





}
