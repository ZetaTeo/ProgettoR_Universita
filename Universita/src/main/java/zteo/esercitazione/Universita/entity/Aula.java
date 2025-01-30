package zteo.esercitazione.Universita.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
* Aula
- **id**
- **nome**
- **capienza**
- **dipartimento_id**
* */

@Entity
@Table(name = "aula")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private int capienza;


    @ManyToOne
    @JoinColumn(name = "dipartimento_id")
    private Dipartimento dipartimento;


}
