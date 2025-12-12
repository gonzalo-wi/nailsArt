package com.nailsbydeni.nails.mapper;

import com.nailsbydeni.nails.dto.TurnoDto;
import com.nailsbydeni.nails.model.Turno;

public class TurnoMapper {
    public static TurnoDto toDto(Turno entity) {
        if (entity == null) return null;
        return TurnoDto.builder()
                .fecha(entity.getFecha())
                .hora(entity.getHora())
                .clienteId(entity.getCliente() != null ? entity.getCliente().getId() : null)
                .servicioId(entity.getServicio() != null ? entity.getServicio().getId() : null)
                .build();
    }


    public static Turno toEntity(TurnoDto dto) {
        if (dto == null) return null;
        Turno entity = new Turno();
        entity.setFecha(dto.getFecha());
        entity.setHora(dto.getHora());
        return entity;
    }


    public static void updateEntity(Turno entity, TurnoDto dto) {
        if (entity == null || dto == null) return;
        if (dto.getFecha() != null) entity.setFecha(dto.getFecha());
        if (dto.getHora() != null) entity.setHora(dto.getHora());

    }
}

