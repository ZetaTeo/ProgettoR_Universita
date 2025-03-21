package zteo.esercitazione.Universita.service;



import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import zteo.esercitazione.Universita.dto.StudenteDto;
import zteo.esercitazione.Universita.entity.Dipartimento;
import zteo.esercitazione.Universita.entity.Studente;
import zteo.esercitazione.Universita.exception.BadRequestException;
import zteo.esercitazione.Universita.exception.ResourceNotFoundException;
import zteo.esercitazione.Universita.repository.DipartimentoRepository;
import zteo.esercitazione.Universita.repository.StudenteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class StudenteService {

    private final StudenteRepository studenteRepository;
    private final DipartimentoRepository dipartimentoRepository;


    // |CREATE
    public StudenteDto createStudente(StudenteDto studenteDto) {
        Dipartimento dipartimento = dipartimentoRepository.findByName(studenteDto.getDipartimento())
                .orElseThrow(() -> new ResourceNotFoundException("Dipartimento " + studenteDto.getDipartimento() + " non trovato"));

        Studente studente = new Studente();

        studente.setNome(studenteDto.getNome());
        studente.setCognome(studenteDto.getCognome());
        studente.setEmail(studenteDto.getEmail());
        studente.setMatricola(studenteDto.getMatricola());
        studente.setCorsoDiLaurea(studenteDto.getCorsoDiLaurea());
       // studente.setCfuTotali(studenteDto.getCfuTotali());
        studente.setDipartimento(dipartimento);

        studenteRepository.save(studente);
        return studenteDto.fromEntityToDto(studente);
    }

    // |UPDATE

    public StudenteDto updateEmailOrMatricolaStudente(String matricolaAttuale, String nuovaMatricola, String nuovaEmail) {

        Studente studente = studenteRepository.findByMatricola(matricolaAttuale)
                .orElseThrow(() -> new ResourceNotFoundException("Studente con matricola " + matricolaAttuale + " non trovato"));

        if (nuovaMatricola != null && !nuovaMatricola.isEmpty() && nuovaMatricola.equals(studente.getMatricola())) {
            throw new BadRequestException("La matricola fornita è la stessa di quella attuale");
        }

        if (nuovaEmail != null && !nuovaEmail.isEmpty() && nuovaEmail.equals(studente.getEmail())) {
            throw new BadRequestException("L'email fornita è la stessa di quella attuale");
        }

        if (nuovaMatricola != null && !nuovaMatricola.isEmpty()) {
            studente.setMatricola(nuovaMatricola);
        }

        if (nuovaEmail != null && !nuovaEmail.isEmpty()) {
            studente.setEmail(nuovaEmail);
        }

        studenteRepository.save(studente);

        return StudenteDto.fromEntityToDto(studente);
    }

    // |DELETE
    public void deleteStudente(String matricola) {
        Studente studente = studenteRepository.findByMatricola(matricola)
                .orElseThrow(() -> new ResourceNotFoundException("Studente con matricola: " + matricola + " non trovato."));

        studenteRepository.delete(studente);
    }

    // Cerca per dipartimento: versione dto with stream
    public List<StudenteDto> getAllStudentsOfDepartment(String nomeDipartimento) {
        dipartimentoRepository.findByName(nomeDipartimento)
                .orElseThrow(() -> new ResourceNotFoundException("Dipartimento " + nomeDipartimento + " non trovato"));

        List<Studente> listaStudenti = studenteRepository.findByDipartimento(nomeDipartimento);

        if (listaStudenti.isEmpty()) {
            throw new ResourceNotFoundException("Nessuno studente trovato per il dipartimento: " + nomeDipartimento);
        }
        return listaStudenti.stream()
                .map(StudenteDto::fromEntityToDto)
                .collect(Collectors.toList());
    }










}
