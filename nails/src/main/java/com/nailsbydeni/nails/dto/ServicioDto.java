package com.nailsbydeni.nails.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServicioDto {
    private Long   id;
    
    @NotBlank(message = "{servicio.nombre.obligatorio}")
    private String nombre;
    
    private String descripcion;
    
    @Positive(message = "{servicio.precio.positive}")
    private Double precio;
    
    @Positive(message = "{servicio.duracion.positive}")
    private Integer duracion;

}
