package com.sqma.auditmodel.events;

import java.io.Serializable;

import com.sqma.model.EvaluacionEscenarioCalidad;

public class QualityEvaluationAvailableEvent implements Serializable {

	private static final long serialVersionUID = 1L;

	private EvaluacionEscenarioCalidad evaluacionEscenarioCalidad;

	public EvaluacionEscenarioCalidad getEvaluacionEscenarioCalidad() {
		return evaluacionEscenarioCalidad;
	}

	public void setEvaluacionEscenarioCalidad(
			EvaluacionEscenarioCalidad evaluacionEscenarioCalidad) {
		this.evaluacionEscenarioCalidad = evaluacionEscenarioCalidad;
	}

}
