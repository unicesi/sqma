package com.sqma.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the proceso_negocio database table.
 * 
 */
@Entity
@Table(name = "proceso_negocio")
public class ProcesoNegocio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SEQ_PROCESO_NEGOCIO_GENERATOR", sequenceName = "SEQ_PROCESO_NEGOCIO", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PROCESO_NEGOCIO_GENERATOR")
	@Column(name = "id_proceso_negocio")
	private Long idProcesoNegocio;

	private String descripcion;

	private String nombre;

	@OneToMany(mappedBy = "procesoNegocio")
	private List<EscenarioCalidad> escenariosCalidad;

	public ProcesoNegocio() {
	}

	public Long getIdProcesoNegocio() {
		return this.idProcesoNegocio;
	}

	public void setIdProcesoNegocio(Long idProcesoNegocio) {
		this.idProcesoNegocio = idProcesoNegocio;
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

	public List<EscenarioCalidad> getEscenariosCalidad() {
		return this.escenariosCalidad;
	}

	public void setEscenariosCalidad(List<EscenarioCalidad> escenariosCalidad) {
		this.escenariosCalidad = escenariosCalidad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (int) (idProcesoNegocio ^ (idProcesoNegocio >>> 32));
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
		ProcesoNegocio other = (ProcesoNegocio) obj;
		if (idProcesoNegocio != other.idProcesoNegocio)
			return false;
		return true;
	}

}