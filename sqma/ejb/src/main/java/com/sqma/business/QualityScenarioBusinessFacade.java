package com.sqma.business;

import java.util.List;

import com.sqma.model.EscenarioCalidad;

public interface QualityScenarioBusinessFacade {

	public List<EscenarioCalidad> findAllQualityScenarios();
	
	public EscenarioCalidad loadScenarioQualityEvaluations(EscenarioCalidad escenarioCalidad);

}
