package com.piriz.proyectoJava.mapper;

import com.piriz.proyectoJava.dto.FacturaDTO;
import com.piriz.proyectoJava.models.Factura;
import java.util.stream.Collectors;

public class FacturaMapper {

    // Convertir entidad Factura a DTO
    public static FacturaDTO toDTO(Factura factura) {
        if (factura == null) {
            return null;
        }

        FacturaDTO dto = new FacturaDTO();
        dto.setId(factura.getId().intValue());
        dto.setCliente(ClienteMapper.toDTO(factura.getCliente()));
        dto.setProductos(factura.getProductos().stream()
                            .map(ProductoMapper::toDTO)
                            .collect(Collectors.toList()));
        dto.setTotal(factura.getTotal());
        return dto;
    }

    // Convertir DTO a entidad Factura
    public static Factura toEntity(FacturaDTO dto) {
        if (dto == null) {
            return null;
        }

        Factura factura = new Factura();
        factura.setId(Long.valueOf(dto.getId()));
        factura.setCliente(ClienteMapper.toEntity(dto.getCliente()));
        factura.setProductos(dto.getProductos().stream()
                                .map(ProductoMapper::toEntity)
                                .collect(Collectors.toList()));
        factura.setTotal(dto.getTotal());
        return factura;
    }
}

