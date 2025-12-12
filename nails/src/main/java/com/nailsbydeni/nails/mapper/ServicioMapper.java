package com.nailsbydeni.nails.mapper;

import com.nailsbydeni.nails.dto.ServicioDto;
import com.nailsbydeni.nails.model.Servicio;

public class ServicioMapper {
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

    public static Servicio toEntity(ServicioDto servicioDto) {
        if(servicioDto == null) {
            return null;
        }
        return Servicio.builder()
                .nombre(servicioDto.getNombre())
                .descripcion(servicioDto.getDescripcion())
                .precio(servicioDto.getPrecio())
                .duracion(servicioDto.getDuracion())
                .build();
    }

    public static Servicio updateEntity(Servicio servicio, ServicioDto dto) {
        servicio.setNombre(dto.getNombre());
        servicio.setDescripcion(dto.getDescripcion());
        servicio.setPrecio(dto.getPrecio());
        servicio.setDuracion(dto.getDuracion());
        return servicio;
    }
}
