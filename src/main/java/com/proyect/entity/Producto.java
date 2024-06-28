package com.proyect.entity;

import com.proyect.data.DTOProductoSave;
import com.proyect.data.DTOProductoUpdate;
import com.proyect.util.Registros;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "tb_producto")
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
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idDataCatalogo")
	private DataCatalogo data_catalogo;

	@Embedded
	private Registros registros = new Registros();

	public Producto(DTOProductoSave dtoProductoSave , DataCatalogo tipo) {
		this.codigo_producto = dtoProductoSave.codigo_producto();
		this.nombre_producto = dtoProductoSave.nombre_producto();
		this.descripcion_producto = dtoProductoSave.descripcion_producto();
		this.precio_producto = dtoProductoSave.precio_producto();
		this.stock_producto = dtoProductoSave.stock_producto();
		this.documento_producto = dtoProductoSave.documento_producto();
		this.data_catalogo = tipo;
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
		if (dtoProductoUpdate.documento_producto() != null) {
			this.documento_producto = dtoProductoUpdate.documento_producto();
		}
		if (dtoProductoUpdate.tipo() != null) {
			this.data_catalogo = dtoProductoUpdate.tipo();
		}
		return this;
	}

	public void desactivarProducto() {
		this.registros.setActivo(false);
	}
	
}
