package com.sqma.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the escenario_calidad database table.
 * 
 */
@Entity
@Table(name = "escenario_calidad")
@NamedQueries({ @NamedQuery(name = "EscenarioCalidad.findAll", query = "select e from EscenarioCalidad e") })
public class EscenarioCalidad implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SEQ_ESCENARIO_CALIDAD_GENERATOR", sequenceName = "SEQ_ESCENARIO_CALIDAD", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ESCENARIO_CALIDAD_GENERATOR")
	@Column(name = "id_escenario_calidad")
	private Long idEscenarioCalidad;

	@Column(name = "componentes_sistema")
	private String componentesSistema;

	@Column(name = "condiciones_ambientales")
	private String condicionesAmbientales;

	private String estimulo;

	@Column(name = "fuente_estimulo")
	private String fuenteEstimulo;

	@Column(name = "indicador")
	private BigDecimal indicador;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "nombre_responsable")
	private String nombreResponsable;

	@Column(name = "correo_responsable")
	private String correoResponsable;

	@ManyToOne
	@JoinColumn(name = "id_metrica_calidad")
	private MetricaCalidad metricaCalidad;

	@ManyToOne
	@JoinColumn(name = "id_proceso_negocio")
	private ProcesoNegocio procesoNegocio;

	@OneToMany(mappedBy = "escenarioCalidad")
	private List<EvaluacionEscenarioCalidad> evaluacionesEscenarioCalidad;

	@OneToMany(mappedBy = "escenarioCalidad")
	private List<MuestraEvaluacion> muestrasEvaluacion;

	@OneToMany(mappedBy = "escenarioCalidad")
	private List<ParametroEscenarioCalidad> parametrosEscenarioCalidad;

	public EscenarioCalidad() {
	}

	public Long getIdEscenarioCalidad() {
		return this.idEscenarioCalidad;
	}

	public void setIdEscenarioCalidad(Long idEscenarioCalidad) {
		this.idEscenarioCalidad = idEscenarioCalidad;
	}

	public String getComponentesSistema() {
		return this.componentesSistema;
	}

	public void setComponentesSistema(String componentesSistema) {
		this.componentesSistema = componentesSistema;
	}

	public String getCondicionesAmbientales() {
		return this.condicionesAmbientales;
	}

	public void setCondicionesAmbientales(String condicionesAmbientales) {
		this.condicionesAmbientales = condicionesAmbientales;
	}

	public String getEstimulo() {
		return this.estimulo;
	}

	public void setEstimulo(String estimulo) {
		this.estimulo = estimulo;
	}

	public String getFuenteEstimulo() {
		return this.fuenteEstimulo;
	}

	public void setFuenteEstimulo(String fuenteEstimulo) {
		this.fuenteEstimulo = fuenteEstimulo;
	}

	public BigDecimal getIndicador() {
		return this.indicador;
	}

	public void setIndicador(BigDecimal indicador) {
		this.indicador = indicador;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreResponsable() {
		return nombreResponsable;
	}

	public void setNombreResponsable(String nombreResponsable) {
		this.nombreResponsable = nombreResponsable;
	}

	public String getCorreoResponsable() {
		return correoResponsable;
	}

	public void setCorreoResponsable(String correoResponsable) {
		this.correoResponsable = correoResponsable;
	}

	public MetricaCalidad getMetricaCalidad() {
		return this.metricaCalidad;
	}

	public void setMetricaCalidad(MetricaCalidad metricaCalidad) {
		this.metricaCalidad = metricaCalidad;
	}

	public ProcesoNegocio getProcesoNegocio() {
		return this.procesoNegocio;
	}

	public void setProcesoNegocio(ProcesoNegocio procesoNegocio) {
		this.procesoNegocio = procesoNegocio;
	}

	public List<EvaluacionEscenarioCalidad> getEvaluacionesEscenarioCalidad() {
		return this.evaluacionesEscenarioCalidad;
	}

	public void setEvaluacionesEscenarioCalidad(
			List<EvaluacionEscenarioCalidad> evaluacionesEscenarioCalidad) {
		this.evaluacionesEscenarioCalidad = evaluacionesEscenarioCalidad;
	}

	public List<MuestraEvaluacion> getMuestrasEvaluacion() {
		return this.muestrasEvaluacion;
	}

	public void setMuestrasEvaluacion(List<MuestraEvaluacion> muestrasEvaluacion) {
		this.muestrasEvaluacion = muestrasEvaluacion;
	}

	public List<ParametroEscenarioCalidad> getParametrosEscenarioCalidad() {
		return parametrosEscenarioCalidad;
	}

	public void setParametrosEscenarioCalidad(
			List<ParametroEscenarioCalidad> parametrosEscenarioCalidad) {
		this.parametrosEscenarioCalidad = parametrosEscenarioCalidad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (int) (idEscenarioCalidad ^ (idEscenarioCalidad >>> 32));
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
		EscenarioCalidad other = (EscenarioCalidad) obj;
		if (idEscenarioCalidad != other.idEscenarioCalidad)
			return false;
		return true;
	}

}