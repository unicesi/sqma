package com.sqma.model.vo;

import java.io.Serializable;
import java.util.Calendar;

public class QualityAuditSampleVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idEscenarioCalidad;

	private Calendar captureDate;

	private String sample;

	public Long getIdEscenarioCalidad() {
		return idEscenarioCalidad;
	}

	public void setIdEscenarioCalidad(Long idEscenarioCalidad) {
		this.idEscenarioCalidad = idEscenarioCalidad;
	}

	public Calendar getCaptureDate() {
		return captureDate;
	}

	public void setCaptureDate(Calendar captureDate) {
		this.captureDate = captureDate;
	}

	public String getSample() {
		return sample;
	}

	public void setSample(String sample) {
		this.sample = sample;
	}

}
