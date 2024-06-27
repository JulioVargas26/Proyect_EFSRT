package com.proyect.repository;

import com.proyect.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    @Query("select t from Producto t where t.registros.activo = true")
    List<Producto> listarRegistrosActivoTrue();

    @Query("select s from Producto s where s.nombre_producto like ?1 and s.registros.activo = true")
    List<Producto> buscarPorNombre(String filtro);

    @Query("select s from Producto s where "
            + "( s.codigo_producto = ?1 ) and "
            + "( s.nombre_producto  like ?2) and "
            + "( s.descripcion_producto like ?3 ) and "
            + "( s.registros.activo = true ) ")
    List<Producto> buscarPorFiltrosGestionProducto(Long cod_prod, String nom_prod, String des_prod);

}
