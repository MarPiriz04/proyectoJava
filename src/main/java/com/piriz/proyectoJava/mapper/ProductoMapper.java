package com.piriz.proyectoJava.mapper;

import com.piriz.proyectoJava.dto.ProductoDTO;
import com.piriz.proyectoJava.models.Producto;

public class ProductoMapper {

    // Convertir entidad Producto a DTO
    public static ProductoDTO toDTO(Producto producto) {
        if (producto == null) {
            return null;
        }

        ProductoDTO dto = new ProductoDTO();
        dto.setId(producto.getId());
        dto.setNombre(producto.getNombre());
        dto.setPrecio(producto.getPrecio());
        return dto;
    }

    // Convertir DTO a entidad Producto
    public static Producto toEntity(ProductoDTO dto) {
        if (dto == null) {
            return null;
        }

        Producto producto = new Producto();
        producto.setId(dto.getId());
        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());
        return producto;
    }
}
