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

    @NotBlank(message = "Il nome non può essere vuoto")
    private String nome;

    @NotBlank(message = "Il cognome non può essere vuoto")
    private String cognome;

    @NotBlank(message = "L'email non può essere vuota")
    private String email;

    @NotBlank(message = "La matricola non può essere vuota")
    @Size(min = 10, max = 10, message = "La matricola deve essere lunga esattamente 10 caratteri")
    private String matricola;

    @NotBlank(message = "Il corso di laurea non può essere vuoto")
    private String corsoDiLaurea;

    @NotNull
    private int cfuTotali;

    @NotBlank(message = "Il dipartimento non può essere vuoto")
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
