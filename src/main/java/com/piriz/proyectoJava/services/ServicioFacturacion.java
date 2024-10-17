package com.piriz.proyectoJava.services;

import com.piriz.proyectoJava.models.Cliente;
import com.piriz.proyectoJava.models.Factura;
import com.piriz.proyectoJava.models.Producto;
import com.piriz.proyectoJava.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioFacturacion {

    @Autowired
    private FacturaRepository facturaRepository;

    // Crear factura para un cliente con una lista de productos
    public Factura crearFactura(Cliente cliente, List<Producto> productos) {
        Factura factura = new Factura();
        factura.setCliente(cliente);
        factura.setProductos(productos);
        factura.setTotal(calcularTotal(productos));
        return facturaRepository.save(factura);
    }

    // Calcular el total de la factura
    private double calcularTotal(List<Producto> productos) {
        return productos.stream().mapToDouble(Producto::getPrecio).sum();
    }

    // Obtener todas las facturas
    public List<Factura> obtenerTodas() {
        return facturaRepository.findAll();
    }

    // Obtener factura por ID
    public Factura obtenerPorId(int id) {
        return facturaRepository.findById(id).orElse(null);
    }

    // Eliminar factura por ID
    public void eliminar(int id) {
        facturaRepository.deleteById(id);
    }
}
