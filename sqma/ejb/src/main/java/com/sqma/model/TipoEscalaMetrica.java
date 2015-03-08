package com.sqma.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the tipo_escala_metrica database table.
 * 
 */
@Entity
@Table(name = "tipo_escala_metrica")
public class TipoEscalaMetrica implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_tipo_escala_metrica")
	private Long idTipoEscalaMetrica;

	private String codigo;

	private String descripcion;

	private String nombre;

	public TipoEscalaMetrica() {
	}

	public Long getIdTipoEscalaMetrica() {
		return this.idTipoEscalaMetrica;
	}

	public void setIdTipoEscalaMetrica(Long idTipoEscalaMetrica) {
		this.idTipoEscalaMetrica = idTipoEscalaMetrica;
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
				+ (int) (idTipoEscalaMetrica ^ (idTipoEscalaMetrica >>> 32));
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
		TipoEscalaMetrica other = (TipoEscalaMetrica) obj;
		if (idTipoEscalaMetrica != other.idTipoEscalaMetrica)
			return false;
		return true;
	}

}