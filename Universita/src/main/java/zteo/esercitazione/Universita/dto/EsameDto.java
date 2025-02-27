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


    private String materia;
    private String matricola;
    private int voto;
    private LocalDate data;
    private int bocciature;

    public static EsameDto fromEntityToDto(Esame esame)
    {
        return new EsameDto
                (
                        esame.getMateria().getNomeMateria(),
                        esame.getStudente().getMatricola(),
                        esame.getVoto(),
                        esame.getData(),
                        esame.getBocciature()

                );
    }
}
