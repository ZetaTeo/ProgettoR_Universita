package zteo.esercitazione.Universita.service;



import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import zteo.esercitazione.Universita.dto.StatsStudenteDto;
import zteo.esercitazione.Universita.dto.StudenteDto;
import zteo.esercitazione.Universita.entity.Dipartimento;
import zteo.esercitazione.Universita.entity.Studente;
import zteo.esercitazione.Universita.entity.enumeration.CorsoDiLaurea;
import zteo.esercitazione.Universita.exception.BadRequestException;
import zteo.esercitazione.Universita.exception.HandleInvalidEnumValue;
import zteo.esercitazione.Universita.exception.ResourceNotFoundException;
import zteo.esercitazione.Universita.repository.DipartimentoRepository;
import zteo.esercitazione.Universita.repository.StudenteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/** JavaDoc
 * Service per la gestione delle operazioni legate agli studenti.
 */
@Service
@RequiredArgsConstructor
public class StudenteService {

    private final StudenteRepository studenteRepository;
    private final DipartimentoRepository dipartimentoRepository;

    /**
     * Crea un nuovo studente a partire da un DTO.
     *
     * @param studenteDto Il DTO contenente le informazioni dello studente da creare.
     * @return Il DTO dello studente creato.
     * @throws ResourceNotFoundException Se il dipartimento specificato non viene trovato.
     * AGGIUNGERE CONTROLLO DIPARTIMENTO!
     */
    public StudenteDto createStudente(StudenteDto studenteDto) {
        Dipartimento dipartimento = dipartimentoRepository.findByName(studenteDto.getDipartimento())
                .orElseThrow(() -> new ResourceNotFoundException("Dipartimento " + studenteDto.getDipartimento() + " non trovato"));

       //CorsoDiLaurea corso = CorsoDiLaurea.fromNome(studenteDto.getCorsoDiLaurea());
        CorsoDiLaurea corso = CorsoDiLaurea.valueOf(studenteDto.getCorsoDiLaurea());

        Studente studente = new Studente();
        studente.setNome(studenteDto.getNome());
        studente.setCognome(studenteDto.getCognome());
        studente.setEmail(studenteDto.getEmail());
        studente.setMatricola(studenteDto.getMatricola());
        studente.setCorsoDiLaurea(corso);
        studente.setDipartimento(dipartimento);

        studenteRepository.save(studente);
        return studenteDto.fromEntityToDto(studente);
    }

    /**
     * Aggiorna la matricola o l'email di uno studente.
     *
     * @param matricolaAttuale La matricola attuale dello studente.
     * @param nuovaMatricola La nuova matricola da impostare.
     * @param nuovaEmail La nuova email da impostare.
     * @return Il DTO aggiornato dello studente.
     * @throws ResourceNotFoundException Se lo studente non viene trovato.
     * @throws BadRequestException Se i nuovi dati coincidono con quelli attuali.
     */
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

    /**
     * Elimina uno studente in base alla sua matricola.
     *
     * @param matricola La matricola dello studente da eliminare.
     * @throws ResourceNotFoundException Se lo studente non viene trovato.
     */
    public void deleteStudente(String matricola) {
        Studente studente = studenteRepository.findByMatricola(matricola)
                .orElseThrow(() -> new ResourceNotFoundException("Studente con matricola: " + matricola + " non trovato."));
        studenteRepository.delete(studente);
    }

    /**
     * Ottiene tutti gli studenti appartenenti a un determinato dipartimento.
     *
     * @param nomeDipartimento Il nome del dipartimento.
     * @return Lista di studenti in formato DTO.
     * @throws ResourceNotFoundException Se il dipartimento o nessuno studente viene trovato.
     */
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

    /**
     * Recupera le statistiche relative a uno studente specifico.
     *
     * @param matricola La matricola dello studente.
     * @return Oggetto {@link StatsStudenteDto} contenente le statistiche.
     * @throws ResourceNotFoundException Se lo studente o le sue statistiche non vengono trovati.
     */
    public StatsStudenteDto getStudentStats(String matricola) {
        Studente studente = studenteRepository.findByMatricola(matricola)
                .orElseThrow(() -> new ResourceNotFoundException("Studente con matricola " + matricola + " non trovato"));

        StatsStudenteDto stats = studenteRepository.getStudentStats(matricola);
        if (stats == null) {
            throw new ResourceNotFoundException("Nessun esame trovato per lo studente con matricola: " + matricola);
        }
        return stats;
    }

   public Page<StudenteDto> getStudentiDipMedia(String dipartimento, double media , Pageable pageable)
   {
       return studenteRepository.findByDipMedia(dipartimento, media, pageable)
               .map(StudenteDto::fromEntityToDto);
   }


}
