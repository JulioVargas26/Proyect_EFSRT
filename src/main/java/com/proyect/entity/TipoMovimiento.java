package com.proyect.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "tipoMovimiento")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id_tipoMov")
public class TipoMovimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tipoMov;
    private String nombre;




}
