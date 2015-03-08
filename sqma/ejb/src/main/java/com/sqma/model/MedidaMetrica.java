package com.sqma.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the medida_metrica database table.
 * 
 */
@Entity
@Table(name = "medida_metrica")
public class MedidaMetrica implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SEQ_MEDIDA_METRICA_GENERATOR", sequenceName = "SEQ_MEDIDA_METRICA", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MEDIDA_METRICA_GENERATOR")
	@Column(name = "id_medida_metrica")
	private Long idMedidaMetrica;

	@Column(name = "codigo_variable")
	private String codigoVariable;

	private String descripcion;

	@Column(name = "indicador_medida_base")
	private Boolean indicadorMedidaBase;

	@Column(name = "indicador_medida_qme")
	private Boolean indicadorMedidaQme;
	
	@Column(name = "indicador_parametro")
	private Boolean indicadorParametro;

	@ManyToOne
	@JoinColumn(name = "id_metrica_calidad")
	private MetricaCalidad metricaCalidad;

	@ManyToOne
	@JoinColumn(name = "id_tipo_medida_metrica")
	private TipoMedidaMetrica tipoMedidaMetrica;

	public MedidaMetrica() {
	}

	public Long getIdMedidaMetrica() {
		return this.idMedidaMetrica;
	}

	public void setIdMedidaMetrica(Long idMedidaMetrica) {
		this.idMedidaMetrica = idMedidaMetrica;
	}

	public String getCodigoVariable() {
		return this.codigoVariable;
	}

	public void setCodigoVariable(String codigoVariable) {
		this.codigoVariable = codigoVariable;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getIndicadorMedidaBase() {
		return indicadorMedidaBase;
	}

	public void setIndicadorMedidaBase(Boolean indicadorMedidaBase) {
		this.indicadorMedidaBase = indicadorMedidaBase;
	}

	public Boolean getIndicadorMedidaQme() {
		return indicadorMedidaQme;
	}

	public void setIndicadorMedidaQme(Boolean indicadorMedidaQme) {
		this.indicadorMedidaQme = indicadorMedidaQme;
	}
	
	public Boolean getIndicadorParametro() {
		return indicadorParametro;
	}

	public void setIndicadorParametro(Boolean indicadorParametro) {
		this.indicadorParametro = indicadorParametro;
	}

	public MetricaCalidad getMetricaCalidad() {
		return this.metricaCalidad;
	}

	public void setMetricaCalidad(MetricaCalidad metricaCalidad) {
		this.metricaCalidad = metricaCalidad;
	}

	public TipoMedidaMetrica getTipoMedidaMetrica() {
		return this.tipoMedidaMetrica;
	}

	public void setTipoMedidaMetrica(TipoMedidaMetrica tipoMedidaMetrica) {
		this.tipoMedidaMetrica = tipoMedidaMetrica;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (int) (idMedidaMetrica ^ (idMedidaMetrica >>> 32));
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
		MedidaMetrica other = (MedidaMetrica) obj;
		if (idMedidaMetrica != other.idMedidaMetrica)
			return false;
		return true;
	}

}