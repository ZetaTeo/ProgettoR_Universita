package zteo.esercitazione.Universita.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "materia")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nomeMateria;

    @Min(value = 0, message = "Codice must be at least 0")
    @Max(value = 180, message = "CFU cannot exceed 180")
    private short cfu;

    @Column(nullable = false)
    private short anno;

    @ManyToMany
    @JoinTable(name = "materia_docente",
            joinColumns = @JoinColumn(name = "materia_id"),
            inverseJoinColumns = @JoinColumn(name = "docente_id")
    )
    private Set<Docente> docenti = new HashSet<>();



}
