package com.proyect.data;

import com.proyect.entity.Producto;

import java.util.Date;

public record DTOProductoList(Long id_producto,
                              int codigo_producto,
                              String nombre_producto,
                              String descripcion_producto,
                              double precio_producto,
                              double stock_producto,
                              String documento_producto,
                              String tipo,
                              String activo,
                              Date creationDate,
                              Date modificationDate) {

    public DTOProductoList(Producto producto){
        this(
                producto.getId_producto(),
                producto.getCodigo_producto(),
                producto.getNombre_producto(),
                producto.getDescripcion_producto(),
                producto.getPrecio_producto(),
                producto.getStock_producto(),
                producto.getDocumento_producto(),
                producto.getData_catalogo().getDescripcion(),
                producto.getRegistros().getReporteEstado(),
                producto.getRegistros().getCreation_date(),
                producto.getRegistros().getModification_date()
        );
    }

}
