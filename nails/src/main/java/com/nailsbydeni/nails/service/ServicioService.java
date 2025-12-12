package com.nailsbydeni.nails.service;

import com.nailsbydeni.nails.dto.ServicioDto;
import com.nailsbydeni.nails.exception.NotFoundException;
import com.nailsbydeni.nails.mapper.ServicioMapper;
import com.nailsbydeni.nails.model.Servicio;
import com.nailsbydeni.nails.repository.ServicioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicioService implements IServicioService {
    private final String MENSAJE_NO_ENCONTRADO = "Servicio no encontrado";
    private final ServicioRepository repository;

    @Override
    public List<ServicioDto> findAll() {
        return repository.findAll()
                .stream()
                .map(ServicioMapper::toDto)
                .toList();
    }


    @Override
    public ServicioDto findById(Long id) {
        return repository.findById(id)
                .map(ServicioMapper::toDto)
                .orElseThrow(() -> new NotFoundException(MENSAJE_NO_ENCONTRADO));
    }

    @Override
    public ServicioDto save(ServicioDto servicioDto) {
        Servicio servicio = ServicioMapper.toEntity(servicioDto);
        return ServicioMapper.toDto(repository.save(servicio));
    }

    @Override
    public ServicioDto update(Long id, ServicioDto servicioDto) {
        Servicio servicio = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(MENSAJE_NO_ENCONTRADO));
        ServicioMapper.updateEntity(servicio, servicioDto);
        return ServicioMapper.toDto(repository.save(servicio));
    }


    @Override
    public void deleteById(Long id) {
        Servicio servicio = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(MENSAJE_NO_ENCONTRADO));
        repository.delete(servicio);
    }
}
