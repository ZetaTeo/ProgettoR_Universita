package zteo.esercitazione.Universita.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Embeddable
@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class EsameId {


    private int studenteId;

    private int materiaId;

    private LocalDate data;
}
