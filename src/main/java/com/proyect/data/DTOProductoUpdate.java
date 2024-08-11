package com.proyect.data;

import com.proyect.entity.DataCatalogo;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DTOProductoUpdate(@NotNull Long id_prod,
                                int cod_prod,
                                String nom_prod,
                                String des_prod,
                                double pre_prod,
                                double sto_prod,
                                String tip_docu,
                                String doc_prod,

                                DataCatalogo dataCatalogo,
                                Boolean activo,
                                LocalDateTime modification_date) {
}
