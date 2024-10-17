package com.piriz.proyectoJava.controllers;

import com.piriz.proyectoJava.dto.ClienteDTO;
import com.piriz.proyectoJava.mapper.ClienteMapper;
import com.piriz.proyectoJava.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<ClienteDTO> obtenerTodos() {
        return clienteService.obtenerTodos().stream().map(ClienteMapper::toDTO).collect(Collectors.toList());
    }

    @PostMapping
    public ClienteDTO guardar(@RequestBody ClienteDTO clienteDTO) {
        return ClienteMapper.toDTO(clienteService.guardar(ClienteMapper.toEntity(clienteDTO)));
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        clienteService.eliminar(id);
    }
}
