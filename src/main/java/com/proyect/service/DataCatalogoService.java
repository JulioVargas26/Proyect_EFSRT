package com.proyect.service;

import com.proyect.entity.Catalogo;
import com.proyect.entity.DataCatalogo;

import java.util.List;

public interface DataCatalogoService {

	public List<DataCatalogo> listarTodos();
	public List<DataCatalogo> listarPorCatalogo(Long catalogoId);
}
