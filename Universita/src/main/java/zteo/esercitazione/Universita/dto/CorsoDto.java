package zteo.esercitazione.Universita.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import zteo.esercitazione.Universita.entity.Corso;

@Data @NoArgsConstructor
@AllArgsConstructor
public class CorsoDto {

    private String nome;

    @Range(min = 4, max = 10)
    private long codice;

    public static CorsoDto fromEntityToDto(Corso corso)
    {
        return new CorsoDto
                (
                   corso.getNome(),
                   corso.getCodice()
                );
    }
}
