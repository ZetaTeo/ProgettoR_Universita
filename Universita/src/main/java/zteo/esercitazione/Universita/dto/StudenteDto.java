package zteo.esercitazione.Universita.dto;



import jakarta.validation.constraints.*;
import lombok.*;
import zteo.esercitazione.Universita.entity.Studente;

/*
Se desideri mantenere il StudenteDto e non creare un DTO separato,
puoi usare @JsonView per controllare quali proprietà vengono mostrate su Swagger.
* @JsonView(Views.Update.class)
    private String email;

    @JsonView(Views.Update.class)
    private String matricola;
* */

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
                  studente.getDipartimento().getNome()

                );
    }



}
