package zteo.esercitazione.Universita.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import zteo.esercitazione.Universita.dto.StudenteDto;
import zteo.esercitazione.Universita.entity.Dipartimento;

import java.util.List;
import java.util.Optional;

public interface DipartimentoRepository extends JpaRepository<Dipartimento, Integer> {

     @Query("SELECT d FROM Dipartimento d WHERE d.nome = :nome")
     Optional<Dipartimento> findByName(String nome);



}
