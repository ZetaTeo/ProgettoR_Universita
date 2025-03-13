package zteo.esercitazione.Universita.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import zteo.esercitazione.Universita.entity.Esame;
import zteo.esercitazione.Universita.entity.Materia;
import zteo.esercitazione.Universita.entity.Studente;

import java.time.LocalDate;
import java.util.Optional;

public interface EsameRepository extends JpaRepository<Esame, Integer> {


    Optional<Esame> findByStudenteAndMateria(Studente studente, Materia materia);

    //Optional<Esame> findByStudenteAndMateriaAndData(Studente studente, Materia materia, LocalDate now);

    @Query(value = """
    SELECT EXISTS (
        SELECT 1 
        FROM studente s 
        JOIN materia m ON s.dipartimento_id = m.dipartimento_id
        WHERE s.id = :studenteId AND m.id = :materiaId
    )
""", nativeQuery = true)
    int verificaAppartenenzaDipartimento( int studenteId,  int materiaId);





}
