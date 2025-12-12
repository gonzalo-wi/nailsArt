package com.nailsbydeni.nails.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TurnoDto {
    @NotNull(message = "{turno.fecha.required}")
    private LocalDate fecha;

    @NotNull(message = "{turno.hora.required}")
    private LocalTime hora;
    
    @NotNull(message = "{turno.clienteId.required}")
    @Positive(message = "{turno.clienteId.positive}")
    private Long clienteId;

    @NotNull(message = "{turno.servicioId.required}")
    @Positive(message = "{turno.servicioId.positive}")
    private Long servicioId;
}
