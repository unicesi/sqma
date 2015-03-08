package com.sqma.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the muestra_evaluacion database table.
 * 
 */
@Entity
@Table(name = "muestra_evaluacion")
public class MuestraEvaluacion implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SEQ_MUESTRA_EVALUACION_GENERATOR", sequenceName = "SEQ_MUESTRA_EVALUACION", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MUESTRA_EVALUACION_GENERATOR")
	@Column(name = "id_muestra_evaluacion")
	private Long idMuestraEvaluacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_recepcion")
	private Calendar fechaRecepcion;

	private String muestra;

	@ManyToOne
	@JoinColumn(name = "id_escenario_calidad")
	private EscenarioCalidad escenarioCalidad;

	@ManyToOne
	@JoinColumn(name = "id_evaluacion_escenario_calidad")
	private EvaluacionEscenarioCalidad evaluacionEscenarioCalidad;

	public MuestraEvaluacion() {
	}

	public Long getIdMuestraEvaluacion() {
		return this.idMuestraEvaluacion;
	}

	public void setIdMuestraEvaluacion(Long idMuestraEvaluacion) {
		this.idMuestraEvaluacion = idMuestraEvaluacion;
	}

	public Calendar getFechaRecepcion() {
		return this.fechaRecepcion;
	}

	public void setFechaRecepcion(Calendar fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	public String getMuestra() {
		return this.muestra;
	}

	public void setMuestra(String muestra) {
		this.muestra = muestra;
	}

	public EscenarioCalidad getEscenarioCalidad() {
		return this.escenarioCalidad;
	}

	public void setEscenarioCalidad(EscenarioCalidad escenarioCalidad) {
		this.escenarioCalidad = escenarioCalidad;
	}

	public EvaluacionEscenarioCalidad getEvaluacionEscenarioCalidad() {
		return this.evaluacionEscenarioCalidad;
	}

	public void setEvaluacionEscenarioCalidad(
			EvaluacionEscenarioCalidad evaluacionEscenarioCalidad) {
		this.evaluacionEscenarioCalidad = evaluacionEscenarioCalidad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (int) (idMuestraEvaluacion ^ (idMuestraEvaluacion >>> 32));
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
		MuestraEvaluacion other = (MuestraEvaluacion) obj;
		if (idMuestraEvaluacion != other.idMuestraEvaluacion)
			return false;
		return true;
	}

}