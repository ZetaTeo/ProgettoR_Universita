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

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate data;

    @NotNull
    private int voto;

    private String materia;

    private String studente;

    public static EsameDto fromEntityToDto(Esame esame)
    {
        return new EsameDto
                (
                   esame.getData(),
                   esame.getVoto(),
                   esame.getMateria().getNomeMateria(),
           esame.getStudente().getNome()  + " " + esame.getStudente().getCognome()
                );
    }
}
