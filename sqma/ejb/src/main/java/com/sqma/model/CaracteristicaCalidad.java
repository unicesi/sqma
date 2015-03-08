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
 * The persistent class for the caracteristica_calidad database table.
 * 
 */
@Entity
@Table(name = "caracteristica_calidad")
public class CaracteristicaCalidad implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SEQ_CARACTERISTICA_CALIDAD_GENERATOR", sequenceName = "SEQ_CARACTERISTICA_CALIDAD", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CARACTERISTICA_CALIDAD_GENERATOR")
	@Column(name = "id_caracteristica_calidad")
	private Long idCaracteristicaCalidad;

	private String codigo;

	private String descripcion;

	private String nombre;

	@ManyToOne
	@JoinColumn(name = "id_caracteristica_calidad_padre")
	private CaracteristicaCalidad caracteristicaCalidadPadre;

	@OneToMany(mappedBy = "caracteristicaCalidadPadre")
	private List<CaracteristicaCalidad> subcaracteristicasCalidad;

	@ManyToOne
	@JoinColumn(name = "id_modelo_calidad")
	private ModeloCalidad modeloCalidad;

	@OneToMany(mappedBy = "caracteristicaCalidad")
	private List<MetricaCalidad> metricasCalidad;

	public CaracteristicaCalidad() {
	}

	public Long getIdCaracteristicaCalidad() {
		return this.idCaracteristicaCalidad;
	}

	public void setIdCaracteristicaCalidad(Long idCaracteristicaCalidad) {
		this.idCaracteristicaCalidad = idCaracteristicaCalidad;
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

	public CaracteristicaCalidad getCaracteristicaCalidadPadre() {
		return this.caracteristicaCalidadPadre;
	}

	public void setCaracteristicaCalidadPadre(
			CaracteristicaCalidad caracteristicaCalidadPadre) {
		this.caracteristicaCalidadPadre = caracteristicaCalidadPadre;
	}

	public List<CaracteristicaCalidad> getSubcaracteristicasCalidad() {
		return this.subcaracteristicasCalidad;
	}

	public void setSubcaracteristicasCalidad(
			List<CaracteristicaCalidad> subcaracteristicasCalidad) {
		this.subcaracteristicasCalidad = subcaracteristicasCalidad;
	}

	public ModeloCalidad getModeloCalidad() {
		return this.modeloCalidad;
	}

	public void setModeloCalidad(ModeloCalidad modeloCalidad) {
		this.modeloCalidad = modeloCalidad;
	}

	public List<MetricaCalidad> getMetricasCalidad() {
		return this.metricasCalidad;
	}

	public void setMetricasCalidad(List<MetricaCalidad> metricasCalidad) {
		this.metricasCalidad = metricasCalidad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ (int) (idCaracteristicaCalidad ^ (idCaracteristicaCalidad >>> 32));
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
		CaracteristicaCalidad other = (CaracteristicaCalidad) obj;
		if (idCaracteristicaCalidad != other.idCaracteristicaCalidad)
			return false;
		return true;
	}

}