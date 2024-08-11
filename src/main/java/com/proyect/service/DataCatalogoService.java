package com.proyect.service;

import com.proyect.entity.DataCatalogo;

import java.util.List;

public interface DataCatalogoService {

	List<DataCatalogo> listarPorCatalogo(Long catalogoId);

}
