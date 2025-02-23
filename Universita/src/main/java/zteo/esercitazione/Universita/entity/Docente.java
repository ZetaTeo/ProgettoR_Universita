package zteo.esercitazione.Universita.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "docente")
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cognome;

    @Column(unique = true, nullable = false)
    private String email;

    @ManyToMany
    @JoinTable(name = "docente_dipartimento",
            joinColumns = @JoinColumn(name = "docente_id"),
            inverseJoinColumns = @JoinColumn(name = "dipartimento_id")
    )
    private Set<Dipartimento> dipartimenti = new HashSet<>();

    @ManyToMany(mappedBy = "docenti")
    private Set<Materia> materie = new HashSet<>();

    @ManyToMany(mappedBy = "docenti")
    private Set<Esame> esami = new HashSet<>();

}
