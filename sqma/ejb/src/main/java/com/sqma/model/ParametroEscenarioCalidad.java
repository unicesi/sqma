package com.sqma.model;

import java.io.Serializable;
import java.math.BigDecimal;

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
 * The persistent class for the parametro_escenario_calidad database table.
 * 
 */
@Entity
@Table(name = "parametro_escenario_calidad")
public class ParametroEscenarioCalidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SEQ_PARAMETRO_ESCENARIO_CALIDAD_GENERATOR", sequenceName = "SEQ_PARAMETRO_ESCENARIO_CALIDAD", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PARAMETRO_ESCENARIO_CALIDAD_GENERATOR")
	@Column(name = "id_parametro_escenario_calidad")
	private long idParametroEscenarioCalidad;

	@ManyToOne
	@JoinColumn(name = "id_escenario_calidad")
	private EscenarioCalidad escenarioCalidad;

	@ManyToOne
	@JoinColumn(name = "id_medida_metrica")
	private MedidaMetrica medidaMetrica;

	@Column(name = "valor_parametro")
	private BigDecimal valorParametro;

	public ParametroEscenarioCalidad() {
	}

	public long getIdParametroEscenarioCalidad() {
		return this.idParametroEscenarioCalidad;
	}

	public void setIdParametroEscenarioCalidad(long idParametroEscenarioCalidad) {
		this.idParametroEscenarioCalidad = idParametroEscenarioCalidad;
	}

	public EscenarioCalidad getEscenarioCalidad() {
		return escenarioCalidad;
	}

	public void setEscenarioCalidad(EscenarioCalidad escenarioCalidad) {
		this.escenarioCalidad = escenarioCalidad;
	}

	public MedidaMetrica getMedidaMetrica() {
		return medidaMetrica;
	}

	public void setMedidaMetrica(MedidaMetrica medidaMetrica) {
		this.medidaMetrica = medidaMetrica;
	}

	public BigDecimal getValorParametro() {
		return this.valorParametro;
	}

	public void setValorParametro(BigDecimal valorParametro) {
		this.valorParametro = valorParametro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ (int) (idParametroEscenarioCalidad ^ (idParametroEscenarioCalidad >>> 32));
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
		ParametroEscenarioCalidad other = (ParametroEscenarioCalidad) obj;
		if (idParametroEscenarioCalidad != other.idParametroEscenarioCalidad)
			return false;
		return true;
	}

}