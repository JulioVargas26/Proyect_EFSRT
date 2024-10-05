package com.proyect.service;

import com.proyect.entity.Proveedor;

import java.util.List;
import java.util.Optional;

public interface ProveedorService {

    Proveedor insertar(Proveedor obj);
    Proveedor actualizar(Proveedor obj);

    Optional<Proveedor> buscarPorId(Long id);

    List<Proveedor> listarRegistrosActivoTrue();
    List<Proveedor> buscarPorFiltrosGestionProveedor(String ruc, String razon_social);

}
