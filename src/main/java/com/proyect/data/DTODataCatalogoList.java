package com.proyect.data;

import com.proyect.entity.DataCatalogo;

public record DTODataCatalogoList(Long idDataCatalogo,
                          String descripcion) {

    public DTODataCatalogoList(DataCatalogo dataCatalogo) {
        this(
                dataCatalogo.getIdDataCatalogo(),
                dataCatalogo.getDescripcion()
        );
    }
}
