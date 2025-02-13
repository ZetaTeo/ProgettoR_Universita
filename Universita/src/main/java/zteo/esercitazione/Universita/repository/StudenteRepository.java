package zteo.esercitazione.Universita.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import zteo.esercitazione.Universita.entity.Studente;

import java.util.Optional;

public interface StudenteRepository extends JpaRepository<Studente, Integer> {






}
