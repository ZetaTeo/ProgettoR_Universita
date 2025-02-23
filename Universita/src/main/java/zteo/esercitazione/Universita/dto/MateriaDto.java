package zteo.esercitazione.Universita.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import zteo.esercitazione.Universita.entity.Materia;

@Data @NoArgsConstructor
@AllArgsConstructor
public class MateriaDto {


    @NotBlank
    private String nome;

    @NotNull
    private int cfu;

    @NotNull
    private short anno;

    public static MateriaDto fromEntityToDto(Materia materia)
    {
        return new MateriaDto
                (
                   materia.getNomeMateria(),
                   materia.getCfu(),
                   materia.getAnno()
                );
    }
}
