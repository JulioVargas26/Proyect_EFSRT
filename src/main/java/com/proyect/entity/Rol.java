package com.proyect.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "rol")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idrol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idrol;
    private String descripcion;

    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rol")
    private List<Usuario> listaUsuario;

    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rol")
    private List<RolEnlace> listaRolEnlace;


}
