package com.proyect.service;

import com.proyect.entity.Tipo;
import com.proyect.repository.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoServiceImp implements TipoService {

	@Autowired
	private TipoRepository repository;

	@Override
	public List<Tipo> listaTodos() {
		return repository.findAll();
	}

	@Override
	public Tipo getReferenceById(Long id) {
		return repository.getOne(id);
	}

}
