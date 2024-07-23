package com.proyect.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.proyect.data.*;
import com.proyect.util.*;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "producto")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id_producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_producto;
	private int codigo_producto;
	private String nombre_producto;
	private String descripcion_producto;
	private double precio_producto;
	private double stock_producto;
	private String documento_producto;
	private String tipo_documento;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name="idDataCatalogo")
	private DataCatalogo dataCatalogo;

	@Embedded
	private Registros registros = new Registros();

	public Producto(DTOProductoSave dtoProductoSave , DataCatalogo dataCatalogo) {
		this.codigo_producto = dtoProductoSave.codigo_producto();
		this.nombre_producto = dtoProductoSave.nombre_producto();
		this.descripcion_producto = dtoProductoSave.descripcion_producto();
		this.precio_producto = dtoProductoSave.precio_producto();
		this.stock_producto = dtoProductoSave.stock_producto();
		this.tipo_documento = String.valueOf(dtoProductoSave.tipo_documento());
		this.documento_producto = dtoProductoSave.documento_producto();
		this.dataCatalogo = dataCatalogo;
	}

	public Producto updateData(DTOProductoUpdate dtoProductoUpdate) {
		if (dtoProductoUpdate.codigo_producto() != 0) {
			this.codigo_producto = dtoProductoUpdate.codigo_producto();
		}
		if (dtoProductoUpdate.nombre_producto() != null) {
			this.nombre_producto = dtoProductoUpdate.nombre_producto();
		}
		if (dtoProductoUpdate.descripcion_producto() != null) {
			this.descripcion_producto = dtoProductoUpdate.descripcion_producto();
		}
		if (dtoProductoUpdate.precio_producto() != 0.0) {
			this.precio_producto = dtoProductoUpdate.precio_producto();
		}
		if (dtoProductoUpdate.stock_producto() != 0.0) {
			this.stock_producto = dtoProductoUpdate.stock_producto();
		}
		if (dtoProductoUpdate.tipo_documento() != null) {
			this.tipo_documento = String.valueOf(dtoProductoUpdate.tipo_documento());
		}
		if (dtoProductoUpdate.documento_producto() != null) {
			this.documento_producto = dtoProductoUpdate.documento_producto();
		}
		if (dtoProductoUpdate.dataCatalogo() != null) {
			this.dataCatalogo = dtoProductoUpdate.dataCatalogo();
		}
		return this;
	}

	public void desactivarProducto() {
		this.registros.setActivo(false);
	}
	
}
