package com.proyect.repository;

import com.proyect.entity.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaisRepository extends JpaRepository<Pais, Integer>{
	
	
	public abstract List<Pais> findByOrderByNombreAsc();
	

}
