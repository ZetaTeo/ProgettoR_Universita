package zteo.esercitazione.Universita.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import zteo.esercitazione.Universita.entity.enumeration.CorsoDiLaurea;


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
    @NotBlank(message = "Il nome non può essere vuoto")
    private String nome;

    @Column(nullable = false)
    @NotBlank(message = "Il cognome non può essere vuoto")
    private String cognome;

    @Email(message = "Email non valida")
    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false, length = 10)
    @Size(min = 10, max = 10, message = "La matricola deve essere lunga esattamente 10 caratteri")
    private String matricola;

    @Min(value = 0, message = "CFU must be a non-negative number")
    @Max(value = 180, message = "CFU cannot exceed 180")
    private int cfuTotali = 0;

    // ===================================== nuova aggiunta
    @Min(value = 0, message = "media artimetica must be a non-negative number")
    @Max(value = 30, message = "media aritmetica cannot exceed 30")
    private double mediaAritmetica = 0.0;

    @Min(value = 0, message = "media ponderata must be a non-negative number")
    @Max(value = 30, message = "media ponderata cannot exceed 30")
    private double mediaPonderata = 0.0;

    @Min(value = 0, message = "media di conseguimento must be a non-negative number")
    @Max(value = 110, message = "media di conseguimento cannot exceed 30")
    private double mediaDiConseguimento = 0.0;
    // ===================================== nuova aggiunta


//    @Column(nullable = false)
//    @NotBlank(message = "Il corso di laurea non può essere vuoto")
//    private String corsoDiLaurea;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CorsoDiLaurea corsoDiLaurea;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Dipartimento dipartimento;

    @OneToMany(mappedBy = "studente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Esame> esami = new ArrayList<>();


}
