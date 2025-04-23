package zteo.esercitazione.Universita.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
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
import java.util.List;
import java.util.logging.Logger;


/**
 * Service per la gestione delle operazioni relative agli esami.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class EsameService {

    private final EsameRepository esameRepository;
    private final StudenteRepository studenteRepository;
    private final MateriaRepository materiaRepository;



    /**
     * Arrotonda un numero a due cifre decimali.
     *
     * @param num Il numero da arrotondare.
     * @return Il numero arrotondato.
     */
    public double dueNumDecimali(double num) {
        return (double) Math.round(num * 100.0) / 100.0;
    }

    /**
     * Rimuove tutti gli esami associati a uno studente e resetta le sue medie.
     *
     * @param matricola La matricola dello studente.
     * @throws ResourceNotFoundException Se lo studente non esiste.
     * @throws IllegalStateException Se non sono presenti esami.
     */
    @Transactional
    public void rimuoviTuttiGliEsami(String matricola) {
        Studente studente = studenteRepository.findByMatricola(matricola)
                .orElseThrow(() -> new ResourceNotFoundException("Studente con matricola " + matricola + " non trovato"));

        List<Esame> listaEsami = esameRepository.findByStudente(studente);

        if (listaEsami.isEmpty()) {
            throw new IllegalStateException("Non ci sono esami all'interno della lista");
        }

        esameRepository.deleteByStudente_Matricola(matricola);

        studente.setMediaAritmetica(0.0);
        studente.setMediaPonderata(0.0);
        studente.setMediaDiConseguimento(0.0);
        studente.setCfuTotali(0);
        studenteRepository.save(studente);
    }

    /**
     * Aggiorna le medie e i CFU totali di uno studente.
     *
     * @param matricola Matricola dello studente.
     * @throws ResourceNotFoundException Se lo studente non esiste.
     */
    public void aggiornaMedie(String matricola) {
        Studente studente = studenteRepository.findByMatricola(matricola)
                .orElseThrow(() -> new ResourceNotFoundException("Studente con matricola " + matricola + " non trovato"));

        List<Esame> listaEsamiPositivi = esameRepository.findByStudenteAndVotoGreaterThanEqual(matricola, 18);

        if (listaEsamiPositivi.isEmpty()) {
            log.info("Nessun esame superato per lo studente con matricola {}", matricola);
            studente.setMediaAritmetica(0);
            studente.setMediaPonderata(0);
            studente.setMediaDiConseguimento(0);
            studente.setCfuTotali(0);
            studenteRepository.save(studente);
            return;
        }


        int sommaPesata = 0;
        int sommaCfu = 0;
        int sommaVoti = 0;

        for (Esame esame : listaEsamiPositivi) {
            sommaPesata += esame.getVoto() * esame.getMateria().getCfu();
            sommaCfu += esame.getMateria().getCfu();
            sommaVoti += esame.getVoto();
        }

        studente.setMediaAritmetica(dueNumDecimali((double) sommaVoti / listaEsamiPositivi.size()));
        studente.setMediaPonderata(dueNumDecimali((double) sommaPesata / sommaCfu));
        studente.setMediaDiConseguimento(dueNumDecimali(studente.getMediaPonderata() * 110 / 30));
        studente.setCfuTotali(sommaCfu);
        studenteRepository.save(studente);
    }

    /**
     * Aggiunge o aggiorna un esame per uno studente.
     *
     * @param materiaEsame Nome della materia.
     * @param matricola Matricola dello studente.
     * @param votoEsame Voto dell'esame.
     * @param dataEsame Data dell'esame.
     * @return Esame creato o aggiornato.
     * @throws ResourceNotFoundException Se lo studente o la materia non esistono.
     * @throws IllegalStateException Se lo studente e la materia non sono compatibili o ci sono errori nei dati.
     */
    public Esame aggiungiEsame(String materiaEsame, String matricola, int votoEsame, LocalDate dataEsame) {
        Studente studente = studenteRepository.findByMatricola(matricola)
                .orElseThrow(() -> new ResourceNotFoundException("Studente con matricola " + matricola + " non trovato"));

        Materia materia = materiaRepository.findByNomeMateria(materiaEsame)
                .orElseThrow(() -> new ResourceNotFoundException("Materia " + materiaEsame + " non trovata"));

        boolean esiste = esameRepository.verificaAppartenenzaDipartimento(studente.getId(), materia.getId()) != 0;
        if (!esiste)
            throw new IllegalStateException("Studente e materia non appartengono allo stesso dipartimento");

        Esame esame = esameRepository.findByStudenteAndMateria(studente, materia).orElse(null);

        if (esame != null) {
            if (esame.getVoto() >= 18)
                throw new IllegalStateException("Esame già superato con " + esame.getVoto());
            if (esame.getData().isEqual(dataEsame))
                throw new IllegalStateException("Esame già sostenuto nella stessa data");

            esame.setVoto(votoEsame);
            esame.setData(dataEsame);
            if (votoEsame < 18)
                esame.setBocciature(esame.getBocciature() + 1);
        } else {
            esame = new Esame(materia, studente, votoEsame, dataEsame, 0);
            if (votoEsame < 18)
                esame.setBocciature(1);
        }

        esame = esameRepository.save(esame);
        aggiornaMedie(matricola);
        return esame;
    }
}
