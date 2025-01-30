package zteo.esercitazione.Universita.dto;


import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;
import zteo.esercitazione.Universita.entity.Studente;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudenteDto {

    private String nome;
    private String cognome;

    @Column(nullable = false, unique = true)
    private String email;


    @Column(unique = true, nullable = false)
    @Size(max = 10)
    private String matricola;

    private String corsoDiLaurea;

    public static StudenteDto fromEntityToDto(Studente studente)
    {
        return new StudenteDto
                (
                  studente.getNome(),
                  studente.getCognome(),
                  studente.getEmail(),
                  studente.getMatricola(),
                  studente.getCorsoDiLaurea()
                );
    }

}
