package zteo.esercitazione.Universita.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zteo.esercitazione.Universita.entity.Dipartimento;

public interface DipartimentoRepository extends JpaRepository<Dipartimento, Integer> {
}
