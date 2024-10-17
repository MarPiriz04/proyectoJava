package com.piriz.proyectoJava;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.piriz.proyectoJava.models.Cliente;
import com.piriz.proyectoJava.models.Producto;
import com.piriz.proyectoJava.services.ClienteService;
import com.piriz.proyectoJava.services.ProductoService;

@SpringBootApplication
public class ProyectoJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProyectoJavaApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(ClienteService clienteService, ProductoService productoService) {
        return args -> {
            // Insertando algunos datos iniciales para testing
            Cliente cliente1 = new Cliente();
            cliente1.setNombre("Mariana");
            cliente1.setEmail("mariana@example.com");
            clienteService.guardar(cliente1);

            Producto producto1 = new Producto();
            producto1.setNombre("Aspirina");
            producto1.setPrecio(100.0);
            productoService.guardar(producto1);

            Producto producto2 = new Producto();
            producto2.setNombre("Paracetamol");
            producto2.setPrecio(80.0);
            productoService.guardar(producto2);
        };
    }
}

