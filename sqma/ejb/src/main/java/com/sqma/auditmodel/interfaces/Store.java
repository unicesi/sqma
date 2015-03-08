package com.sqma.auditmodel.interfaces;

import java.util.List;

import com.sqma.auditmodel.util.exceptions.InvalidSampleScenarioException;
import com.sqma.model.EscenarioCalidad;
import com.sqma.model.MuestraEvaluacion;

public interface Store {

	void queueSamples(List<MuestraEvaluacion> muestras);

	EscenarioCalidad searchQualityScenario(Long idEscenarioCalidad) throws InvalidSampleScenarioException;
}
