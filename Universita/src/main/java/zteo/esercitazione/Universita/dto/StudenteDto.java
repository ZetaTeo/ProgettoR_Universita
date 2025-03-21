package zteo.esercitazione.Universita.dto;


import lombok.*;
import zteo.esercitazione.Universita.entity.Studente;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudenteDto {


    private String nome;

    private String cognome;

    private String email;

    private String matricola;

    private String corsoDiLaurea;

    private int cfuTotali;

    private String dipartimento;

    private double mediaAritmetica;
    private double mediaPonderata;
    private double mediaDiConseguimento;


    public static StudenteDto fromEntityToDto(Studente studente)
    {
        return new StudenteDto
                (
                  studente.getNome(),
                  studente.getCognome(),
                  studente.getEmail(),
                  studente.getMatricola(),
                  studente.getCorsoDiLaurea(),
                  studente.getCfuTotali(),
                  studente.getDipartimento().getNome(),
                  studente.getMediaAritmetica(),
                  studente.getMediaPonderata(),
                  studente.getMediaDiConseguimento()
                );
    }



}
