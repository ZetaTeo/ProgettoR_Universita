package zteo.esercitazione.Universita.dto;


import jakarta.validation.constraints.Pattern;
import lombok.*;
import zteo.esercitazione.Universita.entity.Studente;
import zteo.esercitazione.Universita.entity.enumeration.CorsoDiLaurea;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudenteDto {

    @Pattern(regexp = "^[A-Za-zÀ-ÿ'\\s]+$", message = "Il nome non può contenere numeri o caratteri speciali")
    private String nome;

    @Pattern(regexp = "^[A-Za-zÀ-ÿ'\\s]+$", message = "Il cognome non può contenere numeri o caratteri speciali")
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
                  studente.getCorsoDiLaurea().name(),
                  studente.getCfuTotali(),
                  studente.getDipartimento().getNome(),
                  studente.getMediaAritmetica(),
                  studente.getMediaPonderata(),
                  studente.getMediaDiConseguimento()
                );
    }



}
