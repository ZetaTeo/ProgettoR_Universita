package zteo.esercitazione.Universita.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import zteo.esercitazione.Universita.entity.Corso;

@Data @NoArgsConstructor
@AllArgsConstructor
public class CorsoDto {

    @NotNull
    private int id;

    @NotBlank
    private String nome;

    @NotNull
    private int cfu;

    public static CorsoDto fromEntityToDto(Corso corso)
    {
        return new CorsoDto
                (
                   corso.getId(),
                   corso.getNomeMateria(),
                   corso.getCfu()
                );
    }
}
