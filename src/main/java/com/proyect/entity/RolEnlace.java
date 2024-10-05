package com.proyect.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.proyect.util.Registros;
import com.proyect.util.RolEnlacePK;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "rolEnlace")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RolEnlace {

    @EmbeddedId
    private RolEnlacePK id;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "idrol",insertable = false,updatable = false,referencedColumnName ="idrol")
    private Rol rol;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="idenlace",insertable = false,updatable = false,referencedColumnName = "idenlace")
    private Enlace enlace;
}
