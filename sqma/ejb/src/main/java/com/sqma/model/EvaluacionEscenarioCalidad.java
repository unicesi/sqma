package com.sqma.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * The persistent class for the evaluacion_escenario_calidad database table.
 * 
 */
@Entity
@Table(name = "evaluacion_escenario_calidad")
public class EvaluacionEscenarioCalidad implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SEQ_EVALUACION_ESCENARIO_CALIDAD_GENERATOR", sequenceName = "SEQ_EVALUACION_ESCENARIO_CALIDAD", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EVALUACION_ESCENARIO_CALIDAD_GENERATOR")
	@Column(name = "id_evaluacion_escenario_calidad")
	private Long idEvaluacionEscenarioCalidad;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_fin_proceso")
	private Calendar fechaFinProceso;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_inicio_proceso")
	private Calendar fechaInicioProceso;

	@Transient
	private Long duracionEvaluacion;

	@Column(name = "qme_calculado")
	private BigDecimal qmeCalculado;

	@Column(name = "indicador_descartada")
	private Boolean indicadorDescartada;

	@Column(name = "indicador_violacion")
	private Boolean indicadorViolacion;

	@ManyToOne
	@JoinColumn(name = "id_escenario_calidad")
	private EscenarioCalidad escenarioCalidad;

	@OneToMany(mappedBy = "evaluacionEscenarioCalidad")
	private List<MuestraEvaluacion> muestrasEvaluacion;

	public EvaluacionEscenarioCalidad() {
	}

	public Long getIdEvaluacionEscenarioCalidad() {
		return this.idEvaluacionEscenarioCalidad;
	}

	public void setIdEvaluacionEscenarioCalidad(
			Long idEvaluacionEscenarioCalidad) {
		this.idEvaluacionEscenarioCalidad = idEvaluacionEscenarioCalidad;
	}

	public Calendar getFechaFinProceso() {
		return this.fechaFinProceso;
	}

	public void setFechaFinProceso(Calendar fechaFinProceso) {
		this.fechaFinProceso = fechaFinProceso;
	}

	public Calendar getFechaInicioProceso() {
		return this.fechaInicioProceso;
	}

	public void setFechaInicioProceso(Calendar fechaInicioProceso) {
		this.fechaInicioProceso = fechaInicioProceso;
	}

	public Long getDuracionEvaluacion() {
		if(fechaFinProceso != null && fechaInicioProceso != null){
			duracionEvaluacion = fechaFinProceso.getTimeInMillis()-fechaInicioProceso.getTimeInMillis();
		}
		return duracionEvaluacion;
	}

	public void setDuracionEvaluacion(Long duracionEvaluacion) {
		this.duracionEvaluacion = duracionEvaluacion;
	}

	public BigDecimal getQmeCalculado() {
		return this.qmeCalculado;
	}

	public void setQmeCalculado(BigDecimal qmeCalculado) {
		this.qmeCalculado = qmeCalculado;
	}

	public Boolean getIndicadorDescartada() {
		return indicadorDescartada;
	}

	public void setIndicadorDescartada(Boolean indicadorDescartada) {
		this.indicadorDescartada = indicadorDescartada;
	}

	public Boolean getIndicadorViolacion() {
		return indicadorViolacion;
	}

	public void setIndicadorViolacion(Boolean indicadorViolacion) {
		this.indicadorViolacion = indicadorViolacion;
	}

	public EscenarioCalidad getEscenarioCalidad() {
		return this.escenarioCalidad;
	}

	public void setEscenarioCalidad(EscenarioCalidad escenarioCalidad) {
		this.escenarioCalidad = escenarioCalidad;
	}

	public List<MuestraEvaluacion> getMuestrasEvaluacion() {
		return this.muestrasEvaluacion;
	}

	public void setMuestrasEvaluacion(List<MuestraEvaluacion> muestrasEvaluacion) {
		this.muestrasEvaluacion = muestrasEvaluacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ (int) (idEvaluacionEscenarioCalidad ^ (idEvaluacionEscenarioCalidad >>> 32));
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
		EvaluacionEscenarioCalidad other = (EvaluacionEscenarioCalidad) obj;
		if (idEvaluacionEscenarioCalidad != other.idEvaluacionEscenarioCalidad)
			return false;
		return true;
	}

}