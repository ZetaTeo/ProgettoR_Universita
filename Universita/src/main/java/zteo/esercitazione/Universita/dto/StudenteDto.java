package zteo.esercitazione.Universita.dto;


import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.*;
import zteo.esercitazione.Universita.entity.Studente;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudenteDto {

    @NotBlank
    private String nome;

    @NotBlank
    private String cognome;

    @NotBlank
    private String email;

    @NotBlank
    private String matricola;

    @NotBlank
    private String dipartimento;

    @NotBlank
    private String corsoDiLaurea;

    @NotNull
    private int cfuTotali;


    public static StudenteDto fromEntityToDto(Studente studente)
    {
        return new StudenteDto
                (
                  studente.getNome(),
                  studente.getCognome(),
                  studente.getEmail(),
                  studente.getMatricola(),
                  studente.getDipartimento(),
                  studente.getCorsoDiLaurea(),
                  studente.getCfuTotali()
                );
    }

}
