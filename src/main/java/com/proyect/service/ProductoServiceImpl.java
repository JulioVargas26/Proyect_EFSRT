package com.proyect.service;

import com.proyect.entity.Producto;
import com.proyect.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository productoRepository;

	/*@Override
	public Producto insertar(Producto p) {
		return productoRepository.save(p);
	}*/

	@Override
	public Producto insertar(Producto jp) {
		Producto salida = productoRepository.save(jp);
		return salida;
	}

	@Override
	public Producto actualizar(Producto p) {
		return productoRepository.save(p);
	}

	@Override
	public Optional<Producto> buscarPorId(Long id) {
		return productoRepository.findById(id);
	}

	@Override
	public List<Producto> listarRegistrosActivoTrue() {
		return productoRepository.listarRegistrosActivoTrue();
	}

	@Override
	public List<Producto> buscarPorNombre(String nombre_producto) {
		return productoRepository.buscarPorNombre(nombre_producto);
	}

	@Override
	public List<Producto> buscarPorFiltrosGestionProducto(Long cod_prod, String nom_prod, String des_prod) {
		return productoRepository.buscarPorFiltrosGestionProducto(cod_prod, nom_prod, des_prod);
	}

}