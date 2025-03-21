package zteo.esercitazione.Universita.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import zteo.esercitazione.Universita.entity.Esame;
import zteo.esercitazione.Universita.entity.Materia;
import zteo.esercitazione.Universita.entity.Studente;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EsameRepository extends JpaRepository<Esame, Integer> {


    Optional<Esame> findByStudenteAndMateria(Studente studente, Materia materia);


    @Query(value = """
    SELECT EXISTS (
        SELECT 1 
        FROM studente s 
        JOIN materia m ON s.dipartimento_id = m.dipartimento_id
        WHERE s.id = :studenteId AND m.id = :materiaId
    )
    """, nativeQuery = true)
    Integer verificaAppartenenzaDipartimento(int studenteId, int materiaId);


    @Query("SELECT e FROM Esame e WHERE e.studente.matricola = :matricola AND e.voto >= :voto")
    List<Esame> findByStudenteAndVotoGreaterThanEqual(String matricola, int voto);


    boolean existsByStudente(Studente studente);
}
