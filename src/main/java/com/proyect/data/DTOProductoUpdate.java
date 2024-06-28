package com.proyect.data;

import com.proyect.entity.DataCatalogo;
import com.proyect.entity.Tipo;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DTOProductoUpdate(@NotNull Long id_producto,
                                int codigo_producto,
                                String nombre_producto,
                                String descripcion_producto,
                                double precio_producto,
                                double stock_producto,
                                String documento_producto,

                                DataCatalogo tipo,
                                Boolean activo,
                                LocalDateTime modification_date) {
}
