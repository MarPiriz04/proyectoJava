package com.piriz.proyectoJava.services;

import com.piriz.proyectoJava.models.Factura;
import com.piriz.proyectoJava.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    public List<Factura> obtenerTodas() {
        return facturaRepository.findAll();
    }

    public Factura guardar(Factura factura) {
        return facturaRepository.save(factura);
    }

    public Factura obtenerPorId(int id) {
        return facturaRepository.findById(id).orElse(null);
    }

    public void eliminar(int id) {
        facturaRepository.deleteById(id);
    }
}
