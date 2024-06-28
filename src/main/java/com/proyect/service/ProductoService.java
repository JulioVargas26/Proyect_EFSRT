package com.proyect.service;

import com.proyect.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    public abstract Producto insertar(Producto obj);
    public abstract Producto actualizar(Producto obj);

    public abstract Optional<Producto> buscarPorId(Long id);

    public abstract List<Producto> listarRegistrosActivoTrue();
    public abstract List<Producto> buscarPorNombre(String nombre_producto);
    public abstract List<Producto> buscarPorFiltrosGestionProducto(Long cod_prod, String nom_prod, String des_prod);

}
