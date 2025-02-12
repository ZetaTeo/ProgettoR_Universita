//package zteo.esercitazione.Universita.entity;
//
///*
// Dipartimento
//- **id**
//- **nome**
//- **sede**
//* */
//
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.util.List;
//
//@Entity
//@Table(name = "dipartimento")
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter @Setter
//public class Dipartimento {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @Column(nullable = false)
//    private String nome;
//
//    @Column(nullable = false)
//    private String sede;
//
//    @OneToMany(mappedBy = "dipartimento")
//    private List<Aula> aule;
//
//    @OneToMany(mappedBy = "dipartimento")
//    private List<Docente> docenti;
//
//
//}
