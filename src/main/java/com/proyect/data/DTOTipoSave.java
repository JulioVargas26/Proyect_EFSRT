package com.proyect.data;

import jakarta.validation.constraints.NotBlank;

public record DTOTipoSave(@NotBlank
                          String descripcion) {
}
