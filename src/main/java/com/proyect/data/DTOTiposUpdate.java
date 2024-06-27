package com.proyect.data;

import jakarta.validation.constraints.NotNull;

public record DTOTiposUpdate(@NotNull Long id_tipo,
                             String descripcion) {
}
