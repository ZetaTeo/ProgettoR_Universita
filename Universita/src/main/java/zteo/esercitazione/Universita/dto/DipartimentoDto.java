package zteo.esercitazione.Universita.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import zteo.esercitazione.Universita.entity.Dipartimento;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DipartimentoDto {

    private String nome;

    public static DipartimentoDto fromEntityToDto(Dipartimento dipartimento)
    {
        return new DipartimentoDto
                (
                        dipartimento.getNome()
                );
    }
}
