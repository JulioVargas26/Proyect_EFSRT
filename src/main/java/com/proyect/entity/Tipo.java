package com.proyect.entity;

import com.proyect.data.DTOTipoSave;
import com.proyect.data.DTOTiposUpdate;
import com.proyect.util.Registros;
import jakarta.persistence.*;
import lombok.*;

@Table(name="tb_tipo")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id_tipo")
public class Tipo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_tipo;
	private String descripcion;

	@Embedded
	private Registros registros = new Registros();

	public Tipo(DTOTipoSave dtoTipoSave) {
		this.descripcion = dtoTipoSave.descripcion();
	}

	public Tipo updateData(DTOTiposUpdate dtoTiposUpdate) {
		if (dtoTiposUpdate.descripcion() != null) {
			this.descripcion = dtoTiposUpdate.descripcion();
		}
		return this;
	}

    public void desactivarTipo() {
		this.registros.setActivo(false);
    }
}
