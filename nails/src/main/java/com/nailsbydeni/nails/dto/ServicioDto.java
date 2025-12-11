package com.nailsbydeni.nails.dto;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServicioDto {
    private long   id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int    duracion;

}
