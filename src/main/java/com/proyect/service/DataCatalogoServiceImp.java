package com.proyect.service;

import com.proyect.entity.Catalogo;
import com.proyect.entity.DataCatalogo;
import com.proyect.repository.CatalogoRepository;
import com.proyect.repository.DataCatalogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class DataCatalogoServiceImp implements DataCatalogoService {

	@Autowired
	private DataCatalogoRepository dataCatalogoRepository;

	public List<DataCatalogo> listarTodos(){
		return dataCatalogoRepository.findAll();
	}

	public List<DataCatalogo> listarPorCatalogo(Long catalogoId){
		return dataCatalogoRepository.findAllByCatalogos(catalogoId);
	}

	@Override
	public DataCatalogo getFindById(Long idDataCatalogo) {
		return dataCatalogoRepository.findById(idDataCatalogo).orElse(null);
	}
}
