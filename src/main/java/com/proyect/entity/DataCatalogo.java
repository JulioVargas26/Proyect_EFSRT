package com.proyect.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "data_catalogo")
public class DataCatalogo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDataCatalogo;
	private String descripcion;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCatalogo")
	private Catalogo catalogo;
	
}
