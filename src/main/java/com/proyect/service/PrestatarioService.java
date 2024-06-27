package com.proyect.service;


import com.proyect.entity.Prestatario;

import java.util.List;
import java.util.Optional;

public interface PrestatarioService {

    public abstract Prestatario insertar(Prestatario obj);
    public abstract Prestatario actualizar(Prestatario obj);
    public abstract Optional<Prestatario> buscarPorId(int id);

    public abstract List<Prestatario> buscarPorDni(String nroDocumento);

    public abstract List<Prestatario> buscarPorFiltrosGestionPrestatario(String dni, String nombres, String ape_p, String ape_m);
}
