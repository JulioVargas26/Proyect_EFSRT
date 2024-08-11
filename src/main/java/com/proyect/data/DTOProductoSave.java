package com.proyect.data;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DTOProductoSave(@NotNull
                              int cod_prod,
                              @NotBlank
                              String nom_prod,
                              @NotBlank
                              String des_prod,
                              @NotNull
                              double pre_prod,
                              @NotNull
                              double sto_prod,
                              @NotBlank
                              String tip_docu,
                              @NotBlank
                              String doc_prod,
                              @NotNull
                              @Valid
                              Long dataCatalogo) {
}
