package zteo.esercitazione.Universita.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zteo.esercitazione.Universita.entity.Esame;
import zteo.esercitazione.Universita.entity.Materia;
import zteo.esercitazione.Universita.entity.Studente;

import java.time.LocalDate;
import java.util.Optional;

public interface EsameRepository extends JpaRepository<Esame, Integer> {


    Optional<Esame> findByStudenteAndMateria(Studente studente, Materia materia);

    Optional<Esame> findByStudenteAndMateriaAndData(Studente studente, Materia materia, LocalDate now);
}
