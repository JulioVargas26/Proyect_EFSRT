package com.proyect.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "catalogo")
public class Catalogo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCatalogo;
	private String descripcion;

}
