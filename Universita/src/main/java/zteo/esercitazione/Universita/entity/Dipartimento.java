package zteo.esercitazione.Universita.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "dipartimento")
public class Dipartimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String nome;

    @ManyToMany(mappedBy = "dipartimenti")
    private Set<Docente> docenti = new HashSet<>();

    @OneToMany(mappedBy = "dipartimento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Studente> studenti = new ArrayList<>();

}
