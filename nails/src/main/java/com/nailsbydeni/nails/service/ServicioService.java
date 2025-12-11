package com.nailsbydeni.nails.service;

import com.nailsbydeni.nails.dto.ServicioDto;
import com.nailsbydeni.nails.exception.NotFoundException;
import com.nailsbydeni.nails.mapper.Mapper;
import com.nailsbydeni.nails.model.Servicio;
import com.nailsbydeni.nails.repository.ServicioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioService implements IServicioService {
    private final String MENSAJE_NO_ENCONTRADO = "Servicio no encontrado";
    private final ServicioRepository repository;

    public ServicioService(ServicioRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ServicioDto> findAll() {
        return repository.findAll()
                .stream()
                .map(Mapper::toDto)
                .toList();
    }

    @Override
    public ServicioDto findById(Long id) {
        return repository.findById(id)
                .map(Mapper::toDto)
                .orElseThrow(() -> new NotFoundException(MENSAJE_NO_ENCONTRADO));
    }

    @Override
    public ServicioDto save(ServicioDto servicioDto) {
        Servicio servicio = Servicio.builder()
                .nombre(servicioDto.getNombre())
                .descripcion(servicioDto.getDescripcion())
                .precio(servicioDto.getPrecio())
                .duracion(servicioDto.getDuracion())
                .build();
        return Mapper.toDto(repository.save(servicio));
    }

    @Override
    public ServicioDto update(Long id, ServicioDto servicioDto) {
        Servicio servicio = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(MENSAJE_NO_ENCONTRADO));
        servicio.setNombre(servicioDto.getNombre());
        servicio.setDescripcion(servicioDto.getDescripcion());
        servicio.setPrecio(servicioDto.getPrecio());
        servicio.setDuracion(servicioDto.getDuracion());
        return Mapper.toDto(repository.save(servicio));
    }

    @Override
    public void deleteById(Long id) {
        Servicio servicio = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(MENSAJE_NO_ENCONTRADO));
        repository.delete(servicio);
    }
}
