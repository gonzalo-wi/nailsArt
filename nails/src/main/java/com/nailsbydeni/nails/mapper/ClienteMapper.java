package com.nailsbydeni.nails.mapper;

import com.nailsbydeni.nails.dto.ClienteDto;
import com.nailsbydeni.nails.model.Cliente;

public class ClienteMapper {
    public static ClienteDto toDto(Cliente cliente) {
        if (cliente == null) {
            return null;
        }
        ClienteDto dto = new ClienteDto();
        dto.setNombre(cliente.getNombre());
        dto.setEmail(cliente.getEmail());
        dto.setTelefono(cliente.getTelefono());
        return dto;
    }

    public static Cliente toEntity(ClienteDto dto){
        if(dto == null){
            return null;
        }
        Cliente cliente = new Cliente();
        cliente.setNombre(dto.getNombre());
        cliente.setEmail(dto.getEmail());
        cliente.setTelefono(dto.getTelefono());
        return cliente;
    }

    public static Cliente updateEntity(Cliente cliente, ClienteDto dto){
        cliente.setNombre(dto.getNombre());
        cliente.setEmail(dto.getEmail());
        cliente.setTelefono(dto.getTelefono());
        return cliente;
    }
}
