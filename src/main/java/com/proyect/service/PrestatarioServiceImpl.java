package com.proyect.service;

import com.proyect.entity.Prestatario;
import com.proyect.repository.PrestatarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestatarioServiceImpl implements PrestatarioService {
	@Autowired
	private final PrestatarioRepository repository;

	public PrestatarioServiceImpl(PrestatarioRepository repository) {
		this.repository = repository;
	}

	@Override
	public Prestatario insertar(Prestatario obj) {

		return repository.save(obj);
	}

	@Override
	public Prestatario actualizar(Prestatario obj) {
		return repository.save(obj);
	}

	@Override
	public Optional<Prestatario> buscarPorId(int id) {
		return repository.findById(id);
	}

	@Override
	public List<Prestatario> buscarPorDni(String nroDocumento) {
		return repository.buscarPorDni(nroDocumento);
	}

	@Override
	public List<Prestatario> buscarPorFiltrosGestionPrestatario(String dni, String nombres, String ape_p, String ape_m) {
		return repository.buscarPorFiltrosGestionPrestatario(dni, nombres, ape_p, ape_m);
	}

}