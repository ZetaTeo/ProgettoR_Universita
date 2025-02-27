package zteo.esercitazione.Universita.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Column(unique = true, nullable = false, length = 10)
    @Size(min = 10, max = 10, message = "La matricola deve essere lunga esattamente 10 caratteri")
    private String matricola;

    @Min(value = 0, message = "CFU must be a non-negative number")
    @Max(value = 180, message = "CFU cannot exceed 180")
    private int cfuTotali = 0;

    @Column(nullable = false)
    private String corsoDiLaurea;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Dipartimento dipartimento;

    @OneToMany(mappedBy = "studente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Esame> esami = new ArrayList<>();


}
