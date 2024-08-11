package com.proyect.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "catalogo")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idCatalogo")
public class Catalogo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCatalogo;
	private String descripcion;

}

