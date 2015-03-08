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
 * The persistent class for the metrica_calidad database table.
 * 
 */
@Entity
@Table(name = "metrica_calidad")
public class MetricaCalidad implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SEQ_METRICA_CALIDAD_GENERATOR", sequenceName = "SEQ_METRICA_CALIDAD", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_METRICA_CALIDAD_GENERATOR")
	@Column(name = "id_metrica_calidad")
	private Long idMetricaCalidad;

	@Column(name = "cantidad_muestras_proceso")
	private Long cantidadMuestrasProceso;

	private String codigo;

	private String interpretacion;

	@Column(name = "metodo_aplicacion")
	private String metodoAplicacion;

	private String nombre;

	@Column(name = "periodo_ejecucion")
	private Long periodoEjecucion;

	private String proposito;

	@OneToMany(mappedBy = "metricaCalidad")
	private List<MedidaMetrica> medidasMetrica;

	@ManyToOne
	@JoinColumn(name = "id_caracteristica_calidad")
	private CaracteristicaCalidad caracteristicaCalidad;
	
	@ManyToOne
	@JoinColumn(name = "id_funcion_metrica_calculo")
	private FuncionMetrica funcionMetricaCalculo;
	
	@ManyToOne
	@JoinColumn(name = "id_funcion_metrica_analisis")
	private FuncionMetrica funcionMetricaAnalisis;

	@ManyToOne
	@JoinColumn(name = "id_tipo_escala_metrica")
	private TipoEscalaMetrica tipoEscalaMetrica;
	
	public MetricaCalidad() {
	}

	public Long getIdMetricaCalidad() {
		return this.idMetricaCalidad;
	}

	public void setIdMetricaCalidad(Long idMetricaCalidad) {
		this.idMetricaCalidad = idMetricaCalidad;
	}

	public Long getCantidadMuestrasProceso() {
		return this.cantidadMuestrasProceso;
	}

	public void setCantidadMuestrasProceso(Long cantidadMuestrasProceso) {
		this.cantidadMuestrasProceso = cantidadMuestrasProceso;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getInterpretacion() {
		return this.interpretacion;
	}

	public void setInterpretacion(String interpretacion) {
		this.interpretacion = interpretacion;
	}

	public String getMetodoAplicacion() {
		return this.metodoAplicacion;
	}

	public void setMetodoAplicacion(String metodoAplicacion) {
		this.metodoAplicacion = metodoAplicacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getPeriodoEjecucion() {
		return this.periodoEjecucion;
	}

	public void setPeriodoEjecucion(Long periodoEjecucion) {
		this.periodoEjecucion = periodoEjecucion;
	}

	public String getProposito() {
		return this.proposito;
	}

	public void setProposito(String proposito) {
		this.proposito = proposito;
	}


	public List<MedidaMetrica> getMedidasMetrica() {
		return this.medidasMetrica;
	}

	public void setMedidasMetrica(List<MedidaMetrica> medidasMetrica) {
		this.medidasMetrica = medidasMetrica;
	}

	public CaracteristicaCalidad getCaracteristicaCalidad() {
		return this.caracteristicaCalidad;
	}

	public void setCaracteristicaCalidad(
			CaracteristicaCalidad caracteristicaCalidad) {
		this.caracteristicaCalidad = caracteristicaCalidad;
	}

	public FuncionMetrica getFuncionMetricaCalculo() {
		return funcionMetricaCalculo;
	}

	public void setFuncionMetricaCalculo(FuncionMetrica funcionMetricaCalculo) {
		this.funcionMetricaCalculo = funcionMetricaCalculo;
	}

	public FuncionMetrica getFuncionMetricaAnalisis() {
		return funcionMetricaAnalisis;
	}

	public void setFuncionMetricaAnalisis(FuncionMetrica funcionMetricaAnalisis) {
		this.funcionMetricaAnalisis = funcionMetricaAnalisis;
	}

	public TipoEscalaMetrica getTipoEscalaMetrica() {
		return this.tipoEscalaMetrica;
	}

	public void setTipoEscalaMetrica(TipoEscalaMetrica tipoEscalaMetrica) {
		this.tipoEscalaMetrica = tipoEscalaMetrica;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (int) (idMetricaCalidad ^ (idMetricaCalidad >>> 32));
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
		MetricaCalidad other = (MetricaCalidad) obj;
		if (idMetricaCalidad != other.idMetricaCalidad)
			return false;
		return true;
	}

}