package com.nailsbydeni.nails.service;

import com.nailsbydeni.nails.dto.ClienteDto;

import java.util.List;

public interface IClienteService {
    public List<ClienteDto> findAll();
    public ClienteDto findById(Long id);
    public ClienteDto save(ClienteDto clienteDto);
    public ClienteDto update(Long id, ClienteDto clienteDto);
    public void deleteById(Long id);
}
