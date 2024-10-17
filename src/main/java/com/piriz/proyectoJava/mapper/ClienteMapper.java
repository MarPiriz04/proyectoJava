package com.piriz.proyectoJava.mapper;

import com.piriz.proyectoJava.models.Cliente;
import com.piriz.proyectoJava.dto.ClienteDTO;

public class ClienteMapper {

    // Convierte un objeto Cliente a ClienteDTO
    public static ClienteDTO toDTO(Cliente cliente) {
        if (cliente == null) {
            return null; // Manejo de casos donde cliente sea null
        }
        
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(cliente.getId());
        clienteDTO.setNombre(cliente.getNombre());
        clienteDTO.setEmail(cliente.getEmail());
        // Agregar cualquier otro campo relevante
        
        return clienteDTO;
    }

    // Convierte un objeto ClienteDTO a Cliente (entidad)
    public static Cliente toEntity(ClienteDTO dto) {
        if (dto == null) {
            return null; // Manejo de casos donde dto sea null
        }
        
        Cliente cliente = new Cliente();
        cliente.setId(dto.getId());
        cliente.setNombre(dto.getNombre());
        cliente.setEmail(dto.getEmail());
        // Agregar cualquier otro campo relevante
        
        return cliente;
    }
}