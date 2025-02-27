package zteo.esercitazione.Universita.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "esame")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Esame {


    @EmbeddedId
    private EsameId id;

    @FutureOrPresent(message = "La data non può essere nel passato")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false, insertable = false, updatable = false) // Evita il conflitto nella mappatura
    private LocalDate data;

    @Column(nullable = false)
    private int voto;

    @ManyToOne
    @MapsId("materiaId")
    @JoinColumn(nullable = false)
    private Materia materia;

    @ManyToOne
    @MapsId("studenteId")
    @JoinColumn(nullable = false)
    private Studente studente;

    @Column(nullable = false)
    private int bocciature = 0;


}
