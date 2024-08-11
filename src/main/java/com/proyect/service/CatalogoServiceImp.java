package com.proyect.service;

import com.proyect.entity.Catalogo;
import com.proyect.repository.CatalogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogoServiceImp implements CatalogoService {

	@Autowired
	private CatalogoRepository catalogoRepository;

	@Override
	public List<Catalogo> findAll() {
		return catalogoRepository.findAll();
	}



}
