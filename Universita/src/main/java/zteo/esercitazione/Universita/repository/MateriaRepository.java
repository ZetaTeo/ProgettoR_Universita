package zteo.esercitazione.Universita.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import zteo.esercitazione.Universita.entity.Materia;

import java.util.Optional;

public interface MateriaRepository extends JpaRepository<Materia, Integer> {

    Optional<Materia> findByNomeMateria(String materiaEsame);
}
