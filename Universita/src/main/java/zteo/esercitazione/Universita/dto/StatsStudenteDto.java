package zteo.esercitazione.Universita.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import zteo.esercitazione.Universita.entity.Studente;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatsStudenteDto {

    private int totaleEsami;
    private int esamiPassati;
    private int esamiBocciati;
    private double percentualeCompletamento;
    private double mediaAritmetica;
    private double mediaPonderataAttuale;
    private double mediaDiConseguimento;

    public static StatsStudenteDto fromEntitytoDto(Studente studente)
    {
        return null;
    }
}
