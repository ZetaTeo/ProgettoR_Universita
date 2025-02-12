//package zteo.esercitazione.Universita.entity;
//
///*
//*
//*Docente
//- **id**
//- **nome**
//- **cognome**
//- **email**
//- **dipartimento**
//
//* */
//
//
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.util.List;
//
//@Entity
//@Table(name = "docente")
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//public class Docente {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @Column(nullable = false)
//    private String nome;
//
//    @Column(nullable = false)
//    private String cognome;
//
//    @Column(nullable = false, unique = true)
//    private String email;
//
//    @Column(nullable = false, unique = true)
//    private String codiceFiscale;
//
//    @ManyToOne
//    @JoinColumn(name = "dipartimento_id")
//    private Dipartimento dipartimento;
//
//    @OneToMany(mappedBy = "docente")
//    private List<Corso> corsi;
//
//}
