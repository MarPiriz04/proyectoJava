package com.piriz.proyectoJava.services;

import com.piriz.proyectoJava.models.Cliente;
import com.piriz.proyectoJava.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("unused")
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Obtener todos los clientes
    public List<Cliente> obtenerTodos() {
        return clienteRepository.findAll();
    }

    // Guardar un cliente
    public Cliente guardar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Obtener cliente por ID
    public Cliente obtenerPorId(int id) {
        return clienteRepository.findById(id).orElse(null);
    }

    // Eliminar cliente por ID
    public void eliminar(int id) {
        clienteRepository.deleteById(id);
    }
}