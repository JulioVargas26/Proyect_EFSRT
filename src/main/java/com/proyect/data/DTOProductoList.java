package com.proyect.data;

import com.proyect.entity.Producto;

import java.util.Date;

public record DTOProductoList(Long id_prod,
                              int cod_prod,
                              String nom_prod,
                              String des_prod,
                              double pre_prod,
                              double sto_prod,
                              String doc_prod,
                              String dataCatalogo,
                              String activo,
                              Date creationDate,
                              Date modificationDate) {

    public DTOProductoList(Producto producto){
        this(
                producto.getId_prod(),
                producto.getCod_prod(),
                producto.getNom_prod(),
                producto.getDes_prod(),
                producto.getPre_prod(),
                producto.getSto_prod(),
                producto.getDoc_prod(),
                producto.getDataCatalogo().getDescripcion(),
                producto.getRegistros().getReporteEstado(),
                producto.getRegistros().getCreation_date(),
                producto.getRegistros().getModification_date()
        );
    }

}
