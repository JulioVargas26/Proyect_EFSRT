package com.proyect.data;

import com.proyect.entity.Tipo;

public record DTOTipoList(Long id_tipo,
                          String descripcion) {

    public DTOTipoList(Tipo tipo) {
        this(
                tipo.getId_tipo(),
                tipo.getDescripcion()
        );
    }
}
