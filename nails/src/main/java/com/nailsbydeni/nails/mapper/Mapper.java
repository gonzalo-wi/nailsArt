package com.nailsbydeni.nails.mapper;

import com.nailsbydeni.nails.dto.ServicioDto;
import com.nailsbydeni.nails.model.Servicio;

public class Mapper {
    public static ServicioDto toDto(Servicio servicio) {
        if(servicio == null) {
            return null;
        }
        return ServicioDto.builder()
                .id(servicio.getId())
                .nombre(servicio.getNombre())
                .descripcion(servicio.getDescripcion())
                .precio(servicio.getPrecio())
                .duracion(servicio.getDuracion())
                .build();
    }
}
