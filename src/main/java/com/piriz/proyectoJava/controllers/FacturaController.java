package com.piriz.proyectoJava.controllers;

import com.piriz.proyectoJava.dto.FacturaDTO;
import com.piriz.proyectoJava.mapper.FacturaMapper;
import com.piriz.proyectoJava.models.Cliente;
import com.piriz.proyectoJava.models.Producto;
import com.piriz.proyectoJava.services.ClienteService;
import com.piriz.proyectoJava.services.FacturaService;
import com.piriz.proyectoJava.services.ProductoService;
import com.piriz.proyectoJava.services.ServicioFacturacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/facturas")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ServicioFacturacion servicioFacturacion;

    @GetMapping
    public List<FacturaDTO> obtenerTodas() {
        return facturaService.obtenerTodas().stream().map(FacturaMapper::toDTO).collect(Collectors.toList());
    }

    @PostMapping
    public FacturaDTO crearFactura(@RequestParam int clienteId, @RequestParam List<Integer> productosIds) {
        Cliente cliente = clienteService.obtenerPorId(clienteId);
        List<Producto> productos = productosIds.stream()
                .map(productoService::obtenerPorId)
                .collect(Collectors.toList());

        return FacturaMapper.toDTO(servicioFacturacion.crearFactura(cliente, productos));
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        facturaService.eliminar(id);
    }
}
