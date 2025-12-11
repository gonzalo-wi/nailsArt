package com.nailsbydeni.nails.service;

import com.nailsbydeni.nails.dto.ServicioDto;

import java.util.List;

public interface IServicioService {

    public List<ServicioDto> findAll();
    public ServicioDto findById(Long id);
    public ServicioDto save(ServicioDto servicioDto);
    public ServicioDto update(Long id,ServicioDto servicioDto);
    public void deleteById(Long id);
}
