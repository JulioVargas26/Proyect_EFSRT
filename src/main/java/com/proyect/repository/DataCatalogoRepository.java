package com.proyect.repository;

import com.proyect.entity.DataCatalogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DataCatalogoRepository extends JpaRepository<DataCatalogo, Integer>{
	
	
	@Query("Select r from DataCatalogo r where r.catalogo.idCatalogo =  ?1 order by descripcion asc")
	public abstract List<DataCatalogo> listaDataCatalogo(int idTipo);
}
