package zteo.esercitazione.Universita.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import zteo.esercitazione.Universita.entity.Esame;

import java.time.LocalDate;

@Data @NoArgsConstructor @AllArgsConstructor
public class EsameDto {

    private int id;
    private LocalDate data;
    private int voto;

    public static EsameDto fromEntityToDto(Esame esame)
    {
        return new EsameDto
                (
                   esame.getId(),
                   esame.getData(),
                   esame.getVoto()
                );
    }
}
