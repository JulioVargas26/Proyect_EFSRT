package com.proyect.repository;

import com.proyect.entity.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TipoRepository extends JpaRepository<Tipo, Long> {
    public abstract List<Tipo> findByOrderByDescripcionAsc();

}
