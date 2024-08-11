package com.proyect.service;

import com.proyect.entity.DataCatalogo;
import com.proyect.repository.DataCatalogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataCatalogoServiceImp implements DataCatalogoService {

	@Autowired
	private DataCatalogoRepository dataCatalogoRepository;

	@Override
	public List<DataCatalogo> listarPorCatalogo(Long catalogoId){
		return dataCatalogoRepository.findAllByCatalogo(catalogoId);
	}


}
