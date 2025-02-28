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



//    public Esame aggiungiEsame(String materiaEsame, String matricola, int votoEsame) {
//        // Recupera lo studente dalla matricola
//        Studente studente = studenteRepository.findByMatricola(matricola)
//                .orElseThrow(() -> new ResourceNotFoundException("Lo studente con matricola " + matricola + " non è stato trovato"));
//
//        // Recupera la materia dal nome
//        Materia materia = materiaRepository.findByNomeMateria(materiaEsame)
//                .orElseThrow(() -> new ResourceNotFoundException("La materia " + materiaEsame + " non è stata trovata"));
//
//        // Cerca un esame già registrato per quello studente e quella materia
//        Optional<Esame> esameEsistente = esameRepository.findByStudenteAndMateria(studente, materia);
//
//        Esame esame = new Esame();
//
//        if (esameEsistente.isPresent()) {
//            // Se l'esame esiste, lo recuperiamo
//            esame = esameEsistente.get();
//
//            // Se il voto dell'esame esistente è maggiore o uguale a 18, blocchiamo la modifica
//            if (esame.getVoto() >= 18) {
//                throw new IllegalStateException("Non è possibile modificare l'esame perché il voto è già maggiore o uguale a 18.");
//            }
//
//            // Se il voto del nuovo esame è inferiore a 18, incrementiamo le bocciature
//            if (votoEsame < 18) {
//                esame.setBocciature(esame.getBocciature() + 1);
//            } else {
//                // Se il voto è maggiore o uguale a 18, aggiorniamo i CFU
//                studente.setCfuTotali(studente.getCfuTotali() + materia.getCfu());
//                studenteRepository.save(studente);
//            }
//
//            // Aggiorniamo il voto e la data
//            esame.setVoto(votoEsame);
//            esame.setData(LocalDate.now());
//
//        } else {
//            // Se non esiste, lo creiamo
//            esame = new Esame();
//            esame.setStudente(studente);
//            esame.setMateria(materia);
//            esame.setVoto(votoEsame);
//            esame.setData(LocalDate.now());
//            esame.setBocciature(votoEsame < 18 ? 1 : 0);
//
//            // Se supera l'esame, aggiungiamo i CFU
//            if (votoEsame >= 18) {
//                studente.setCfuTotali(studente.getCfuTotali() + materia.getCfu());
//                studenteRepository.save(studente);
//            }
//        }
//
//
//        return esameRepository.save(esame);
//        //return EsameDto.fromEntityToDto(esameRepository.save(esame));
//    }

//    public Esame aggiungiEsame(String materiaEsame, String matricola, int votoEsame) {
//
//
//        // Recupera lo studente dalla matricola
//        Studente studente = studenteRepository.findByMatricola(matricola)
//                .orElseThrow(() -> new ResourceNotFoundException("Lo studente con matricola " + matricola + " non è stato trovato"));
//
//        // Recupera la materia dal nome
//        Materia materia = materiaRepository.findByNomeMateria(materiaEsame)
//                .orElseThrow(() -> new ResourceNotFoundException("La materia " + materiaEsame + " non è stata trovata"));
//
//
//
//        // Cerca se esiste già un esame per lo studente nella materia
//        Optional<Esame> esameEsistente = esameRepository.findByStudenteAndMateriaAndData(studente, materia, LocalDate.now());
//
//
//        Esame esame = new Esame();
//
//        if (esameEsistente.isPresent()) {
//            // Se l'esame esiste già, aggiorniamo il voto e la data
//            esame = esameEsistente.get();
//
//            // Verifica che la data non sia la stessa (non si possono sostenere due esami nello stesso giorno)
//            if (esame.getData().isEqual(LocalDate.now())) {
//                throw new IllegalStateException("Non puoi sostenere due esami della stessa materia lo stesso giorno.");
//            }
//
//            // Se il voto è >= 18, aggiorniamo i CFU
//            if (votoEsame >= 18) {
//                studente.setCfuTotali(studente.getCfuTotali() + materia.getCfu());
//                studenteRepository.save(studente);
//            } else {
//                // Se il voto è < 18, incrementiamo le bocciature
//                esame.setBocciature(esame.getBocciature() + 1);
//            }
//
//            // Aggiorna il voto e la data
//            esame.setVoto(votoEsame);
//            esame.setData(LocalDate.now());
//
//        } else {
//            // Se l'esame non è mai stato sostenuto, creiamo un nuovo esame
//            esame.setStudente(studente);
//            esame.setMateria(materia);
//            esame.setVoto(votoEsame);
//            esame.setData(LocalDate.now());
//            esame.setBocciature(votoEsame < 18 ? 1 : 0);
//
//            // Se il voto è >= 18, aggiungiamo i CFU
//            if (votoEsame >= 18) {
//                studente.setCfuTotali(studente.getCfuTotali() + materia.getCfu());
//                studenteRepository.save(studente);
//            }
//        }
//
//        System.out.println(esame); // Aggiungi un log per ispezionare l'oggetto
//
//        // Salva l'esame nel repository
//        return esameRepository.save(esame);
//    }


//    public Esame aggiungiEsame(String materiaEsame, String matricola, int votoEsame) {
//
//        // Recupera lo studente dalla matricola
//        Studente studente = studenteRepository.findByMatricola(matricola)
//                .orElseThrow(() -> new ResourceNotFoundException("Lo studente con matricola " + matricola + " non è stato trovato"));
//
//        // Recupera la materia dal nome
//        Materia materia = materiaRepository.findByNomeMateria(materiaEsame)
//                .orElseThrow(() -> new ResourceNotFoundException("La materia " + materiaEsame + " non è stata trovata"));
//
//        // Cerca se esiste già un esame per lo studente nella materia sostenuto oggi
//        Optional<Esame> esameEsistente = esameRepository.findByStudenteAndMateriaAndData(studente, materia, LocalDate.now());
//
//        Esame esame;
//
//        if (esameEsistente.isPresent()) {
//            // Se l'esame esiste già, aggiorniamo il voto e la data
//            esame = esameEsistente.get();
//
//            // Verifica che la data non sia la stessa (non si possono sostenere due esami nello stesso giorno)
//            if (esame.getData().isEqual(LocalDate.now())) {
//                throw new IllegalStateException("Non puoi sostenere due esami della stessa materia lo stesso giorno.");
//            }
//
//            // Se il voto è >= 18, aggiorniamo i CFU
//            if (votoEsame >= 18) {
//                studente.setCfuTotali(studente.getCfuTotali() + materia.getCfu());
//                studenteRepository.save(studente);
//            } else {
//                // Se il voto è < 18, incrementiamo le bocciature
//                esame.setBocciature(esame.getBocciature() + 1);
//            }
//
//            // Aggiorna il voto e la data
//            esame.setVoto(votoEsame);
//            //esame.setData(LocalDate.now());
//            esame.setData(dataEsame);
//
//        } else {
//
//
//            // 🟢 SOLUZIONE: Creiamo l'oggetto Esame con l'ID inizializzato
//            esame = new Esame(materia, studente, votoEsame, LocalDate.now(), votoEsame < 18 ? 1 : 0);
//
//            // Se il voto è >= 18, aggiorniamo i CFU dello studente
//            if (votoEsame >= 18) {
//                studente.setCfuTotali(studente.getCfuTotali() + materia.getCfu());
//                studenteRepository.save(studente);
//            }
//        }
//
//        // 🛠 Debug: Verifica che l'ID non sia null prima di salvare
//        System.out.println("ID Esame prima di salvare: " + esame.getId());
//
//        // ✅ Ora Hibernate può salvare l'esame senza problemi
//        return esameRepository.save(esame);
//    }

    public Esame aggiungiEsame(String materiaEsame, String matricola, int votoEsame, LocalDate dataEsame) {

        // Recupera lo studente dalla matricola
        Studente studente = studenteRepository.findByMatricola(matricola)
                .orElseThrow(() -> new ResourceNotFoundException("Lo studente con matricola " + matricola + " non è stato trovato"));

        // Recupera la materia dal nome
        Materia materia = materiaRepository.findByNomeMateria(materiaEsame)
                .orElseThrow(() -> new ResourceNotFoundException("La materia " + materiaEsame + " non è stata trovata"));

        // Recupera l'ultimo esame sostenuto per la materia
        Optional<Esame> esameEsistente = esameRepository.findByStudenteAndMateria(studente, materia);

        Esame esame;

        if (esameEsistente.isPresent()) {
            esame = esameEsistente.get();

            // 🚨 BLOCCO: Se l'esame ha già un voto >= 18, non può essere modificato
            if (esame.getVoto() >= 18) {
                throw new IllegalStateException("L'esame con voto " + esame.getVoto() + " non può essere modificato.");
            }

            // 🚨 Se la nuova data è uguale a quella dell'ultimo esame, blocchiamo
            if (esame.getData().isEqual(dataEsame)) {
                throw new IllegalStateException("Non puoi sostenere due esami della stessa materia lo stesso giorno.");
            }

            // Se il voto è < 18, incrementiamo le bocciature
            if (votoEsame < 18) {
                esame.setBocciature(esame.getBocciature() + 1);
            } else {
                // Se il voto è >= 18, aggiorniamo i CFU e blocchiamo future modifiche
                studente.setCfuTotali(studente.getCfuTotali() + materia.getCfu());
                studenteRepository.save(studente);
            }

            // Aggiorniamo i dati
            esame.setVoto(votoEsame);
            esame.setData(dataEsame);

        } else {
            // Creiamo un nuovo esame con la data scelta
            esame = new Esame(materia, studente, votoEsame, dataEsame, votoEsame < 18 ? 1 : 0);

            // Se il voto è >= 18, aggiorniamo i CFU dello studente
            if (votoEsame >= 18) {
                studente.setCfuTotali(studente.getCfuTotali() + materia.getCfu());
                studenteRepository.save(studente);
            }
        }

        return esameRepository.save(esame);
    }



}
