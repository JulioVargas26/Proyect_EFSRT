package com.proyect.repository;

import com.proyect.entity.DataCatalogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DataCatalogoRepository extends JpaRepository<DataCatalogo, Long>{

	@Query("Select dc from DataCatalogo dc where dc.catalogo.idCatalogo=?1")
    List<DataCatalogo> findAllByCatalogo(Long catalogoId);

}
