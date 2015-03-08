package com.sqma.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the fase_producto database table.
 * 
 */
@Entity
@Table(name = "fase_producto")
public class FaseProducto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_fase_producto")
	private Long idFaseProducto;

	private String codigo;

	private String descripcion;

	private String nombre;

	@OneToMany(mappedBy = "faseProducto")
	private List<ModeloCalidad> modelosCalidad;

	public FaseProducto() {
	}

	public Long getIdFaseProducto() {
		return this.idFaseProducto;
	}

	public void setIdFaseProducto(Long idFaseProducto) {
		this.idFaseProducto = idFaseProducto;
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

	public List<ModeloCalidad> getModelosCalidad() {
		return this.modelosCalidad;
	}

	public void setModelosCalidad(List<ModeloCalidad> modelosCalidad) {
		this.modelosCalidad = modelosCalidad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (int) (idFaseProducto ^ (idFaseProducto >>> 32));
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
		FaseProducto other = (FaseProducto) obj;
		if (idFaseProducto != other.idFaseProducto)
			return false;
		return true;
	}

}