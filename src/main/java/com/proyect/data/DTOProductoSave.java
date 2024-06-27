package com.proyect.data;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DTOProductoSave(@NotNull
                              int codigo_producto,
                              @NotBlank
                              String nombre_producto,
                              @NotBlank
                              String descripcion_producto,
                              @NotNull
                              double precio_producto,
                              @NotNull
                              double stock_producto,
                              @NotBlank
                              String documento_producto,
                              @NotNull
                              @Valid
                              Long tipo) {
}
