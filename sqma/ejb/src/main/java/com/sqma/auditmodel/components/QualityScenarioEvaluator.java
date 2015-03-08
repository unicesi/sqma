package com.sqma.auditmodel.components;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;

import com.sqma.auditmodel.events.QualityEvaluationAvailableEvent;
import com.sqma.auditmodel.interfaces.Evaluator;
import com.sqma.auditmodel.util.EmailUtil;
import com.sqma.auditmodel.util.GroovyUtil;
import com.sqma.auditmodel.util.QualityModelUtil;
import com.sqma.auditmodel.util.exceptions.ScriptExcecutionException;
import com.sqma.model.EscenarioCalidad;
import com.sqma.model.EvaluacionEscenarioCalidad;

@Stateless
public class QualityScenarioEvaluator implements Evaluator {

	
	@PersistenceContext(name="sqmaPU")
	private EntityManager em;
	
	@Inject
	private Logger logger;
	
	@Override
	public void evaluateScenario(QualityEvaluationAvailableEvent event) {

		EvaluacionEscenarioCalidad evaluacionEscenarioCalidad = null;
		EscenarioCalidad escenarioCalidad = null;
		boolean serviceLevelViolationFlag = false;
		String qmeAnalysisScript = null;
		
		evaluacionEscenarioCalidad = event.getEvaluacionEscenarioCalidad();
		escenarioCalidad = evaluacionEscenarioCalidad.getEscenarioCalidad();
		escenarioCalidad = em.merge(escenarioCalidad);
		qmeAnalysisScript = escenarioCalidad.getMetricaCalidad().getFuncionMetricaAnalisis().getFuncion();
		try {
			serviceLevelViolationFlag = GroovyUtil.executeAnalysisMetricGroovyFunction(qmeAnalysisScript,
					escenarioCalidad.getIndicador(), evaluacionEscenarioCalidad.getQmeCalculado(),
					QualityModelUtil.buildMetricParameters(escenarioCalidad.getParametrosEscenarioCalidad()));
		} catch (ScriptExcecutionException e) {
			evaluacionEscenarioCalidad.setIndicadorDescartada(true);
			logger.error("Error evaluating QME analysis fuction.", e);
		}
		evaluacionEscenarioCalidad.setIndicadorViolacion(serviceLevelViolationFlag);
		evaluacionEscenarioCalidad = em.merge(evaluacionEscenarioCalidad);
		em.flush();
		if (serviceLevelViolationFlag) {
			EmailUtil.sendServiceLevelViolationEmail(evaluacionEscenarioCalidad);
		}
	}

}
