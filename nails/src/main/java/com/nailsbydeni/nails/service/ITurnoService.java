package com.nailsbydeni.nails.service;

import com.nailsbydeni.nails.dto.TurnoDto;

import java.util.List;

public interface ITurnoService {
    public List<TurnoDto> findAll();
    public TurnoDto findById(Long id);
    public TurnoDto save(TurnoDto turnoDto);
    public TurnoDto update(Long id, TurnoDto turnoDto);
    public void deleteById(Long id);
}
