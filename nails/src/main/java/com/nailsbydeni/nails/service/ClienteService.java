package com.nailsbydeni.nails.service;

import com.nailsbydeni.nails.dto.ClienteDto;
import com.nailsbydeni.nails.exception.NotFoundException;
import com.nailsbydeni.nails.mapper.ClienteMapper;
import com.nailsbydeni.nails.model.Cliente;
import com.nailsbydeni.nails.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class ClienteService implements IClienteService {
private final MessageSource messageSource;
private final ClienteRepository repository;

    @Override
    public List<ClienteDto> findAll() {
        return repository.findAll()
                .stream().map(ClienteMapper::toDto)
                .toList();
    }


    @Override
    public ClienteDto findById(Long id) {
        return repository.findById(id)
                .map(ClienteMapper::toDto)
                .orElseThrow(() -> new NotFoundException(messageSource.getMessage("cliente.notfound", null, Locale.getDefault())));
    }


    @Override
    public ClienteDto save(ClienteDto clienteDto) {
        Cliente cliente = ClienteMapper.toEntity(clienteDto);
        return ClienteMapper.toDto(repository.save(cliente));
    }


    @Override
    public ClienteDto update(Long id, ClienteDto clienteDto) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(messageSource.getMessage("cliente.notfound", null, Locale.getDefault())));
        ClienteMapper.updateEntity(cliente, clienteDto);
        return ClienteMapper.toDto(repository.save(cliente));
    }


    @Override
    public void deleteById(Long id) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(messageSource.getMessage("cliente.notfound", null, Locale.getDefault())));
        repository.delete(cliente);
    }
}
