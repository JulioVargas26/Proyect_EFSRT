package com.proyect.data;

import com.proyect.entity.Catalogo;

public record DTOCatalogoList(Long idCatalogo,
                              String descripcion) {

    public DTOCatalogoList(Catalogo catalogo) {
        this(
                catalogo.getIdCatalogo(),
                catalogo.getDescripcion()
        );
    }
}

