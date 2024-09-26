package com.proyect.repository;

import com.proyect.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    @Query("select t from Producto t " +
            "where t.registros.activo = true")
    List<Producto> listarRegistrosActivoTrue();

    @Query("select s from Producto s " +
            "where s.nom_prod like ?1 " +
            "and s.registros.activo = true")
    List<Producto> buscarPorNombre(String filtro);

    @Query("select s from Producto s where (?1 = 0 or s.cod_prod = ?1 ) and (s.nom_prod  like ?2) "     +
            "and (s.des_prod like ?3 ) and s.registros.activo = true  ")
    List<Producto> buscarPorFiltrosGestionProducto(Long cod_prod, String nom_prod, String des_prod);

   /* @Query("select x from Sala x where (x.numero like ?1) and "
            + "(?2 = 0 or x.piso = ?2) and "
            + "(x.recursos like ?3) and "
            + "(x.estado = ?4) and "
            + "(?5 = -1 or x.tipoSala.idDataCatalogo = ?5) and"
            + "(?6 = -1 or x.sede.idDataCatalogo = ?6)")
    public List<Sala> listaConsultaDinamica(String numero, int piso, String recursos, int estado, int idTipoSala,int idSede);*/


}
