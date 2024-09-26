	package com.proyect.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.proyect.data.DTOProductoSave;
import com.proyect.data.DTOProductoUpdate;
import com.proyect.util.Registros;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "producto")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id_prod")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_prod;
	private int cod_prod;
	private String nom_prod;
	private double pre_prod;
	private double sto_prod;
	private String des_prod;
	private String tip_docu;
	private String doc_prod;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name="idDataCatalogo")
	private DataCatalogo dataCatalogo;

	@Embedded
	private Registros registros = new Registros();

	public Producto(DTOProductoSave dtoProductoSave , DataCatalogo dataCatalogo) {
		this.cod_prod = dtoProductoSave.cod_prod();
		this.nom_prod = dtoProductoSave.nom_prod();
		this.des_prod = dtoProductoSave.des_prod();
		this.pre_prod = dtoProductoSave.pre_prod();
		this.sto_prod = dtoProductoSave.sto_prod();
		this.tip_docu = dtoProductoSave.tip_docu();
		this.doc_prod = dtoProductoSave.doc_prod();
		this.dataCatalogo = dataCatalogo;
	}

	public Producto updateData(DTOProductoUpdate dtoProductoUpdate) {
		if (dtoProductoUpdate.cod_prod() != 0) {
			this.cod_prod = dtoProductoUpdate.cod_prod();
		}
		if (dtoProductoUpdate.nom_prod() != null) {
			this.nom_prod = dtoProductoUpdate.nom_prod();
		}
		if (dtoProductoUpdate.des_prod() != null) {
			this.des_prod = dtoProductoUpdate.des_prod();
		}
		if (dtoProductoUpdate.pre_prod() != 0.0) {
			this.pre_prod = dtoProductoUpdate.pre_prod();
		}
		if (dtoProductoUpdate.sto_prod() != 0.0) {
			this.sto_prod = dtoProductoUpdate.sto_prod();
		}
		if (dtoProductoUpdate.tip_docu() != null) {
			this.tip_docu =dtoProductoUpdate.tip_docu();
		}
		if (dtoProductoUpdate.doc_prod() != null) {
			this.doc_prod = dtoProductoUpdate.doc_prod();
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
