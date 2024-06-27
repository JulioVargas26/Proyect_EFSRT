package com.proyect.service;

import com.proyect.entity.Sala;
import com.proyect.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaServiceImpl implements SalaService {
	@Autowired
    private final SalaRepository repository;

    
    public SalaServiceImpl(SalaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Sala insertaSala(Sala obj) {
        return repository.save(obj);
    }

    @Override
    public Sala actualizaSala(Sala obj) {
        return repository.save(obj);
    }

    @Override
    public Optional<Sala> buscaSala(int idSala) {
        return repository.findById(idSala);
    }

    @Override
    public List<Sala> buscarNumeroSala(String numeroSala) {
        return repository.findByNumeroIgnoreCase(numeroSala);
    }

    @Override
    public List<Sala> buscarNumeroOrRecursosLike(String filtro) {
        return repository.listaSalaPorNumeroOrRecursosLike(filtro);
    }

    @Override
    public List<Sala> buscarSalaConsultaFiltrar( String numero, int piso, String recursos, int numAlumnos, int idSede, int idTipoSala,int estado) {
        return repository.buscarSalaConsulta(numero,piso,recursos,numAlumnos,idSede,idTipoSala,estado);
    }

}