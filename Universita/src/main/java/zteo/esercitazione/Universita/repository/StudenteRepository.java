package zteo.esercitazione.Universita.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import zteo.esercitazione.Universita.dto.StatsStudenteDto;
import zteo.esercitazione.Universita.dto.StudenteDto;
import zteo.esercitazione.Universita.entity.Dipartimento;
import zteo.esercitazione.Universita.entity.Studente;


import java.util.List;
import java.util.Optional;

public interface StudenteRepository extends JpaRepository<Studente, Integer> {



    Optional <Studente> findByMatricola(String matricola);

    @Query ("SELECT s FROM Studente s WHERE s.dipartimento.nome = :nomeDipartimento")
    List<Studente> findByDipartimento(String nomeDipartimento);


    @Query("SELECT new zteo.esercitazione.Universita.dto.StatsStudenteDto(" +
            "CAST(COUNT(e) AS int), " + // Numero totale di esami sostenuti
            "CAST(SUM(CASE WHEN e.voto >= 18 THEN 1 ELSE 0 END) AS int), " + // Numero di esami passati
            "CAST(SUM(CASE WHEN e.voto < 18 THEN 1 ELSE 0 END) AS int), " + // Numero di esami bocciati
            "CAST((SUM(CASE WHEN e.voto >= 18 THEN 1 ELSE 0 END) * 100.0) / COUNT(e) AS double), " + // Percentuale di esami superati
            "s.mediaPonderata, " +
            "s.mediaAritmetica, " +
            "s.mediaDiConseguimento " +// Media ponderata precedente
            //"CAST(AVG(e.voto) AS double), " +// Media ponderata dopo
            //"CAST((AVG(e.voto) - s.mediaPonderata) AS double) " + // Differenza tra media attuale e media ponderata
            ") " +
            "FROM Studente s " +
            "JOIN s.esami e " +
            "WHERE s.matricola = :matricola")
    StatsStudenteDto getStudentStats(String matricola);

    @Query("SELECT s FROM Studente s WHERE LOWER(s.dipartimento.nome) = LOWER(:dipartimento) AND s.mediaAritmetica >= :media")
    Page<Studente> findByDipMedia(String dipartimento, double media, Pageable pageable);
}
