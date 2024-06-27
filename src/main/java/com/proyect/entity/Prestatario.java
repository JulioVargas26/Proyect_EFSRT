package com.proyect.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "prestatario")
public class Prestatario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombres;
	private String apellido_paterno;
	private String apellido_materno;
	private String email;
	private String direccion;
	private String contacto;
	private String tipoDocumento;
	private String nroDocumento;
	@Temporal(TemporalType.DATE)
    private String fechaNacimiento;
	private String genero; 
	private String estadoCivil;
	private String nacionalidad;
	private String salarioMensual;
	private boolean activo; 

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private Date fechaRegistro;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private Date fechaActualizacion;

	

}
