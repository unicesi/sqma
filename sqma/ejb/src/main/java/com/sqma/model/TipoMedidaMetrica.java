package com.sqma.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the tipo_medida_metrica database table.
 * 
 */
@Entity
@Table(name = "tipo_medida_metrica")
public class TipoMedidaMetrica implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_tipo_medida_metrica")
	private Long idTipoMedidaMetrica;

	private String codigo;

	private String descripcion;

	private String nombre;

	public TipoMedidaMetrica() {
	}

	public Long getIdTipoMedidaMetrica() {
		return this.idTipoMedidaMetrica;
	}

	public void setIdTipoMedidaMetrica(Long idTipoMedidaMetrica) {
		this.idTipoMedidaMetrica = idTipoMedidaMetrica;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (int) (idTipoMedidaMetrica ^ (idTipoMedidaMetrica >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoMedidaMetrica other = (TipoMedidaMetrica) obj;
		if (idTipoMedidaMetrica != other.idTipoMedidaMetrica)
			return false;
		return true;
	}

}