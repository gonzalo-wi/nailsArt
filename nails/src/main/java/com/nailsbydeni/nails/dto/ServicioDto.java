package com.nailsbydeni.nails.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServicioDto {
    private Long   id;
    
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    
    private String descripcion;
    
    @Positive(message = "El precio debe ser mayor a 0")
    private Double precio;
    
    @Positive(message = "La duración debe ser mayor a 0")
    private Integer duracion;

}
