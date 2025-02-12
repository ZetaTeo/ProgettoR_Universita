package zteo.esercitazione.Universita.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import zteo.esercitazione.Universita.dto.StudenteDto;
import zteo.esercitazione.Universita.entity.Studente;
import zteo.esercitazione.Universita.exception.IllegalArgumentException;
import zteo.esercitazione.Universita.exception.ResourceNotFoundException;
import zteo.esercitazione.Universita.repository.StudenteRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudenteService {

    private final StudenteRepository studenteRepository;


//
//
//    public StudenteDto addStudente(StudenteDto studenteDto)
//    {
//        if (studenteRepository.findByMatricola(studenteDto.getMatricola()).isPresent()) {
//            throw new IllegalArgumentException("Studente già esistente");
//        }
//
//        if(studenteRepository.findByEmail(studenteDto.getEmail()).isPresent())
//        {
//            throw new IllegalArgumentException("Email già presente");
//        }
//
//        Studente studente = new Studente();
//
//        studente.setNome(studenteDto.getNome());
//        studente.setCognome(studenteDto.getCognome());
//        studente.setEmail(studenteDto.getEmail());
//        studente.setMatricola(studenteDto.getMatricola());
//        studente.setCorsoDiLaurea(studenteDto.getCorsoDiLaurea());
//
//        studenteRepository.save(studente);
//
//        return studenteDto.fromEntityToDto(studente);
//
//    }
//
//    public StudenteDto getStudenteByMatricola(String matricola) {
//        Studente studente = studenteRepository.findByMatricola(matricola)
//                .orElseThrow(() -> new IllegalArgumentException("Studente non trovato"));
//
//        return StudenteDto.fromEntityToDto(studente);
//    }
//
//    public StudenteDto updateStudente(StudenteDto studenteDto, String matricola)
//    {
//        Studente studente = studenteRepository.findByMatricola(matricola)
//                .orElseThrow(() -> new IllegalArgumentException("Studente non trovato"));
//
//        studente.setNome(studenteDto.getNome());
//        studente.setCognome(studenteDto.getCognome());
//        studente.setEmail(studenteDto.getEmail());
//        studente.setMatricola(studenteDto.getMatricola());
//        studente.setCorsoDiLaurea(studenteDto.getCorsoDiLaurea());
//
//
//        studenteRepository.save(studente);
//
//        return studenteDto.fromEntityToDto(studente);
//    }
//
////    @Transactional
////    public void eliminaStudentePerMatricola(String matricola) {
////
////
////        studenteRepository.deleteByMatricola(matricola);
////    }
//
//    @Transactional
//    public void eliminaStudentePerMatricola(String matricola) {
//        // Verifica se lo studente con la matricola esiste
//        Optional<Studente> studente = studenteRepository.findByMatricola(matricola);
//
//        // Se non esiste, lancia un'eccezione
//        if (studente.isEmpty()) {
//            throw new ResourceNotFoundException("Studente con matricola " + matricola + " non trovato.");
//        }
//
//        // Procedi con l'eliminazione
//        studenteRepository.deleteByMatricola(matricola);
//    }










}
