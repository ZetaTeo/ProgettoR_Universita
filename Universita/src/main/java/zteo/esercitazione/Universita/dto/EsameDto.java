package zteo.esercitazione.Universita.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import zteo.esercitazione.Universita.entity.Esame;

import java.time.LocalDate;

@Data @NoArgsConstructor @AllArgsConstructor
public class EsameDto {


    private int id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate data;

    @NotNull
    private int voto;

    @NotNull
    private boolean superato;

    public static EsameDto fromEntityToDto(Esame esame)
    {
        return new EsameDto
                (
                   esame.getId(),
                   esame.getData(),
                   esame.getVoto(),
                   esame.isSuperato()
                );
    }
}
