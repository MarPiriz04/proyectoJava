package com.piriz.proyectoJava.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity 
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Identificador único para cada factura

    @ManyToOne // Relación muchos-a-uno con la clase Cliente
    private Cliente cliente; // El cliente asociado a la factura

    @ManyToMany // Relación muchos-a-muchos con la clase Producto
    private List<Producto> productos; // Lista de productos en la factura

    private double total; // El total de la factura

    // Constructor por defecto (requerido por JPA)
    public Factura() {
    }

    // Constructor que acepta cliente y productos (opcional)
    public Factura(Cliente cliente, List<Producto> productos) {
        this.cliente = cliente;
        this.productos = productos;
        this.total = calcularTotal(productos); // Calcula el total automáticamente
    }

    // Método para calcular el total de la factura basado en la lista de productos
    private double calcularTotal(List<Producto> productos) {
        return productos.stream().mapToDouble(Producto::getPrecio).sum();
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
        this.total = calcularTotal(productos); // Actualiza el total cuando se setean los productos
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}

