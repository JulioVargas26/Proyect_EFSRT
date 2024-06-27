package com.proyect.service;

import com.proyect.entity.Producto;
import com.proyect.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

	private final ProductoRepository repository;

	public ProductoServiceImpl(ProductoRepository repository) {
		this.repository = repository;
	}

	@Override
	public Producto insertar(Producto obj) {
		return repository.save(obj);
	}

	@Override
	public Producto actualizar(Producto obj) {
		return repository.save(obj);
	}

	@Override
	public Optional<Producto> buscarPorId(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<Producto> listarRegistrosActivoTrue() {
		return repository.listarRegistrosActivoTrue();
	}

	@Override
	public List<Producto> buscarPorNombre(String nombre_producto) {
		return repository.buscarPorNombre(nombre_producto);
	}

	@Override
	public List<Producto> buscarPorFiltrosGestionProducto(Long cod_prod, String nom_prod, String des_prod) {
		return repository.buscarPorFiltrosGestionProducto(cod_prod, nom_prod, des_prod);
	}

}