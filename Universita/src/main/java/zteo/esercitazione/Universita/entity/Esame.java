package zteo.esercitazione.Universita.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate data;

    @Column(nullable = false)
    private int voto;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Materia materia;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Studente studente;

    public boolean isSuperato()
    {
        return voto >= 18;
    }

    @ManyToMany
    @JoinTable(
            name = "esame_docente",  // Nome della tabella intermedia con colonne esame_id e docente_id
            joinColumns = @JoinColumn(name = "esame_id"),  // Colonna entità corrente
            inverseJoinColumns = @JoinColumn(name = "docente_id") // Colonna entità collegata
    )
    private Set<Docente> docenti = new HashSet<>();
}
