//package zteo.esercitazione.Universita.dto;
//
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import zteo.esercitazione.Universita.entity.Docente;
//
//@Data @AllArgsConstructor @NoArgsConstructor
//public class DocenteDto {
//
//    private String nome;
//    private String cognome;
//    private String email;
//    private String codiceFiscale;
//
//    public static DocenteDto fromEntityToDto(Docente docente)
//    {
//        return new DocenteDto
//                (
//                   docente.getNome(),
//                   docente.getCognome(),
//                   docente.getEmail(),
//                   docente.getCodiceFiscale()
//                );
//    }
//}
