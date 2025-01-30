package zteo.esercitazione.Universita.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;


import java.util.List;

@Entity
@Table(name = "studente")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Studente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cognome;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)

    private String matricola;

    @Column(nullable = false)
    private String corsoDiLaurea;

    @OneToMany(mappedBy = "studente")
    private List<Esame> esami;


}
