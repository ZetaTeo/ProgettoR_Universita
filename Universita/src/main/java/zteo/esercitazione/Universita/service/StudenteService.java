package zteo.esercitazione.Universita.service;



import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import zteo.esercitazione.Universita.dto.StudenteDto;
import zteo.esercitazione.Universita.entity.Dipartimento;
import zteo.esercitazione.Universita.entity.Studente;
import zteo.esercitazione.Universita.exception.ResourceNotFoundException;
import zteo.esercitazione.Universita.repository.DipartimentoRepository;
import zteo.esercitazione.Universita.repository.StudenteRepository;

import java.util.Map;


@Service
@RequiredArgsConstructor
public class StudenteService {

    private final StudenteRepository studenteRepository;
    private final DipartimentoRepository dipartimentoRepository;

    public StudenteDto createStudente(StudenteDto studenteDto)
    {
        Dipartimento dipartimento = dipartimentoRepository.findByName(studenteDto.getDipartimento())
                .orElseThrow(() -> new ResourceNotFoundException("Dipartimento " + studenteDto.getDipartimento() + " non trovato"));

        Studente studente = new Studente();

        studente.setNome(studenteDto.getNome());
        studente.setCognome(studenteDto.getCognome());
        studente.setEmail(studenteDto.getEmail());
        studente.setMatricola(studenteDto.getMatricola());
        studente.setCorsoDiLaurea(studenteDto.getCorsoDiLaurea());
        studente.setCfuTotali(studenteDto.getCfuTotali());
        studente.setDipartimento(dipartimento);

        studenteRepository.save(studente);
        return studenteDto.fromEntityToDto(studente);
    }


    public StudenteDto updateEmailStudente(String matricola, String nuovaEmail)
    {
        Studente studente = studenteRepository.findByMatricola(matricola)
                .orElseThrow(() -> new ResourceNotFoundException("Studente con matricola " + matricola + " non trovato"));

        studente.setEmail(nuovaEmail);
        studenteRepository.save(studente);
        return StudenteDto.fromEntityToDto(studente);
    }

    public StudenteDto updateEmailAndMatricolaStudente(String matricolaAttuale, Map<String, String> updates) {
        Studente studente = studenteRepository.findByMatricola(matricolaAttuale)
                .orElseThrow(() -> new ResourceNotFoundException("Studente con matricola " + matricolaAttuale + " non trovato"));


        if (updates.containsKey("email")) {
            studente.setEmail(updates.get("email"));
        }
        if (updates.containsKey("matricola")) {
            studente.setMatricola(updates.get("matricola"));
        }

        studenteRepository.save(studente);
        return StudenteDto.fromEntityToDto(studente);
    }


    public void deleteStudente(String matricola)
    {
        Studente studente = studenteRepository.findByMatricola(matricola)
                .orElseThrow(() -> new ResourceNotFoundException("Studente con matricola: " + matricola + " non trovato."));

        studenteRepository.delete(studente);
    }








}
