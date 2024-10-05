package com.proyect.data;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DTOProductoSave(@NotBlank
                              String cod_prod,
                              /*@NotBlank
                              String nom_prod,*/
                              @NotBlank
                              String des_prod,
                              @NotBlank
                              String tip_mone,
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
