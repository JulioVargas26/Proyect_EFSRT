package com.proyect.repository;

import com.proyect.entity.Proveedor;
import com.proyect.entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {

    @Query("select t from Proveedor t " +
            "where t.registros.activo = true")
    List<Proveedor> listarRegistrosActivoTrue();

    @Query("select s from Proveedor s where (s.ruc like ?1 ) and (s.razon_social like ?2 ) and s.registros.activo = true  ")
    List<Proveedor> buscarPorFiltrosGestionProveedor(String ruc, String razon_social);

   /* @Query("select x from Sala x where (x.numero like ?1) and "
            + "(?2 = 0 or x.piso = ?2) and "
            + "(x.recursos like ?3) and "
            + "(x.estado = ?4) and "
            + "(?5 = -1 or x.tipoSala.idDataCatalogo = ?5) and"
            + "(?6 = -1 or x.sede.idDataCatalogo = ?6)")
    public List<Sala> listaConsultaDinamica(String numero, int piso, String recursos, int estado, int idTipoSala,int idSede);*/


}
