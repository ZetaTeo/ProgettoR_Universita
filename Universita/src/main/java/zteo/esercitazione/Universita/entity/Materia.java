package zteo.esercitazione.Universita.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @ManyToOne
    @JoinColumn(nullable = false)
    private Dipartimento dipartimento;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Docente docente;

    @OneToMany(mappedBy = "materia", cascade = CascadeType.ALL)
    private List<Esame> esami;


}
