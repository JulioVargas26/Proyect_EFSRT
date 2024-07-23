package com.proyect.data;

import com.proyect.entity.DataCatalogo;
import com.proyect.util.TipoDocumento;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DTOProductoUpdate(@NotNull Long id_producto,
                                int codigo_producto,
                                String nombre_producto,
                                String descripcion_producto,
                                double precio_producto,
                                double stock_producto,
                                TipoDocumento tipo_documento,
                                String documento_producto,

                                DataCatalogo dataCatalogo,
                                Boolean activo,
                                LocalDateTime modification_date) {
}
