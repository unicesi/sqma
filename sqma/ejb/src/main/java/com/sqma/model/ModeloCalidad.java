package com.sqma.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the modelo_calidad database table.
 * 
 */
@Entity
@Table(name = "modelo_calidad")
public class ModeloCalidad implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SEQ_MODELO_CALIDAD_GENERATOR", sequenceName = "SEQ_MODELO_CALIDAD", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MODELO_CALIDAD_GENERATOR")
	@Column(name = "id_modelo_calidad")
	private Long idModeloCalidad;

	private String codigo;

	private String descripcion;

	private String nombre;

	@OneToMany(mappedBy = "modeloCalidad")
	private List<CaracteristicaCalidad> caracteristicasCalidad;

	@ManyToOne
	@JoinColumn(name = "id_fase_producto")
	private FaseProducto faseProducto;

	public ModeloCalidad() {
	}

	public Long getIdModeloCalidad() {
		return this.idModeloCalidad;
	}

	public void setIdModeloCalidad(Long idModeloCalidad) {
		this.idModeloCalidad = idModeloCalidad;
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

	public List<CaracteristicaCalidad> getCaracteristicasCalidad() {
		return this.caracteristicasCalidad;
	}

	public void setCaracteristicasCalidad(
			List<CaracteristicaCalidad> caracteristicasCalidad) {
		this.caracteristicasCalidad = caracteristicasCalidad;
	}

	public FaseProducto getFaseProducto() {
		return this.faseProducto;
	}

	public void setFaseProducto(FaseProducto faseProducto) {
		this.faseProducto = faseProducto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (int) (idModeloCalidad ^ (idModeloCalidad >>> 32));
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
		ModeloCalidad other = (ModeloCalidad) obj;
		if (idModeloCalidad != other.idModeloCalidad)
			return false;
		return true;
	}

}