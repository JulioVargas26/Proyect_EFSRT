package com.proyect.repository;

import com.proyect.entity.DataCatalogo;
import org.springframework.data.jpa.repository.*;

import java.util.List;

public interface DataCatalogoRepository extends JpaRepository<DataCatalogo, Long>{

	@Query("Select r from DataCatalogo r where r.catalogo.idCatalogo = ?1")
	public abstract List<DataCatalogo> findAllByCatalogos(Long catalogoId);


}
