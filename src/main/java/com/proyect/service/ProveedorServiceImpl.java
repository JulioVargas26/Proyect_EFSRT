package com.proyect.service;

import com.proyect.entity.Proveedor;
import com.proyect.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorServiceImpl implements ProveedorService {

	@Autowired
	private ProveedorRepository ProveedorRepository;

	@Override
	public Proveedor insertar(Proveedor p) {
		return ProveedorRepository.save(p);
	}

	@Override
	public Proveedor actualizar(Proveedor p) {
		return ProveedorRepository.save(p);
	}

	@Override
	public Optional<Proveedor> buscarPorId(Long id) {
		return ProveedorRepository.findById(id);
	}

	@Override
	public List<Proveedor> listarRegistrosActivoTrue() {
		return ProveedorRepository.listarRegistrosActivoTrue();
	}

	@Override
	public List<Proveedor> buscarPorFiltrosGestionProveedor(String ruc, String razon_social) {
		return ProveedorRepository.buscarPorFiltrosGestionProveedor(ruc, razon_social);
	}

}