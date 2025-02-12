package zteo.esercitazione.Universita.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "corso")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Corso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nome;

    @Min(value = 0, message = "Codice must be at least 0")
    @Max(value = 180, message = "CFU cannot exceed 180")
    private int cfu;

//    @ManyToOne
//    @JoinColumn(name = "docente_id")
//    private Docente docente;

    @OneToMany(mappedBy = "corso")
    private List<Esame> esami;
}
