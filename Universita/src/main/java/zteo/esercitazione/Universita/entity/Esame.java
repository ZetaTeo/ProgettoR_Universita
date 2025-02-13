package zteo.esercitazione.Universita.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

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

    @Column(nullable = false)
    private boolean superato;

    @ManyToOne
    @JoinColumn(name = "corso_id")
    private Corso corso;

    @ManyToOne
    @JoinColumn(name = "studente_id")
    private Studente studente;

    @PrePersist
    @PreUpdate
    public void calcolaSuperamento()
    {
        this.superato = this.voto >= 18;
    }

}
