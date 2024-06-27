package com.proyect.repository;

import com.proyect.entity.Prestatario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PrestatarioRepository extends JpaRepository<Prestatario, Integer> {
	List<Prestatario> findByNombresIgnoreCase(String nombreSala);

	@Query("select s from Prestatario s where s.nroDocumento like ?1 and s.activo = true")
	List<Prestatario> buscarPorDni(String filtro);

	@Query("select s from Prestatario s where ( s.nroDocumento like ?1 ) and ( s.nombres like ?2 ) and "
			+ "( s.apellido_paterno like ?3 ) and ( s.apellido_materno like ?4) and s.activo = true  ")
	List<Prestatario> buscarPorFiltrosGestionPrestatario(String dni, String nombres, String ape_p, String ape_m);

}
