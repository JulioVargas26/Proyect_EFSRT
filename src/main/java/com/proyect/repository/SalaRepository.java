package com.proyect.repository;

import com.proyect.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SalaRepository extends JpaRepository<Sala, Integer> {
    List<Sala> findByNumeroIgnoreCase(String nombreSala);

    @Query("select s from Sala s where s.numero like ?1 or s.recursos like ?1 ")
    List<Sala> listaSalaPorNumeroOrRecursosLike(String filtro);

    @Query("select s from Sala s where "
            + "( s.numero like ?1 ) and "
            + "( ?2 = -1 or s.piso  = ?2) and "
            + "( s.recursos like ?3 ) and "
            + "( ?4 = -1 or s.numAlumnos  = ?4) and "
            + "( ?6 = -1 or s.tipoSala.idDataCatalogo = ?6 ) and "
            + "( ?7 = -1 or s.estado = ?7 ) and "
            + "( ?5 = -1 or s.sede.idDataCatalogo = ?5 ) ")
    List<Sala> buscarSalaConsulta( String numero, int piso, String recursos, int numAlumnos, int idSede, int idTipoSala,int estado);

}
