package com.piriz.proyectoJava.services;

import com.piriz.proyectoJava.models.Producto;
import com.piriz.proyectoJava.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    // Obtener todos los productos
    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    // Guardar un producto
    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }

    // Obtener producto por ID
    public Producto obtenerPorId(int id) {
        return productoRepository.findById(id).orElse(null);
    }

    // Eliminar producto por ID
    public void eliminar(int id) {
        productoRepository.deleteById(id);
    }
}
