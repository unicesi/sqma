package com.sqma.auditmodel.components;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;

import com.sqma.auditmodel.events.QualityEvaluationAvailableEvent;
import com.sqma.auditmodel.events.QualitySamplesAvailableEvent;
import com.sqma.auditmodel.interfaces.Evaluator;
import com.sqma.auditmodel.interfaces.Processor;
import com.sqma.auditmodel.util.GroovyUtil;
import com.sqma.auditmodel.util.QualityModelUtil;
import com.sqma.auditmodel.util.exceptions.ScriptExcecutionException;
import com.sqma.model.EscenarioCalidad;
import com.sqma.model.EvaluacionEscenarioCalidad;
import com.sqma.model.MuestraEvaluacion;

@Stateless
public class QualityAuditProcessor implements Processor {
	
	
	@PersistenceContext(name="sqmaPU")
	private EntityManager em;
	
	@EJB
	private Evaluator qualityAuditEvaluator;
	
	
	@Inject
	private Logger logger;
	
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void processSamples(QualitySamplesAvailableEvent event) {
		EvaluacionEscenarioCalidad evaluacionEscenarioCalidad = null;
		EscenarioCalidad escenarioCalidad = null;
		String qmeGeneratorScript = null;
		BigDecimal qmeValue = null;
		
		storeSamples(event.getMuestrasEvaluacion());
		evaluacionEscenarioCalidad = new EvaluacionEscenarioCalidad();
		evaluacionEscenarioCalidad.setMuestrasEvaluacion(event.getMuestrasEvaluacion());
		escenarioCalidad = event.getMuestrasEvaluacion().get(0).getEscenarioCalidad();
		evaluacionEscenarioCalidad.setIndicadorDescartada(false);
		evaluacionEscenarioCalidad.setEscenarioCalidad(escenarioCalidad);
		qmeGeneratorScript = escenarioCalidad.getMetricaCalidad().getFuncionMetricaCalculo().getFuncion();
		evaluacionEscenarioCalidad.setFechaInicioProceso(Calendar.getInstance());
		try {
			qmeValue = GroovyUtil.executeProcessMetricGroovyFunction(qmeGeneratorScript,
					QualityModelUtil.getSamplesAsStringArray(event.getMuestrasEvaluacion()),
					QualityModelUtil.buildMetricParameters(escenarioCalidad.getParametrosEscenarioCalidad()));
			evaluacionEscenarioCalidad.setQmeCalculado(qmeValue);
			
		} catch (ScriptExcecutionException e) {
			evaluacionEscenarioCalidad.setIndicadorDescartada(true);
			logger.error("Error evaluating sample pack. Discarding samples.", e);
		}
		evaluacionEscenarioCalidad.setIndicadorViolacion(false);
		evaluacionEscenarioCalidad.setFechaFinProceso(Calendar.getInstance());
		em.persist(evaluacionEscenarioCalidad);
		em.flush();
		if(!evaluacionEscenarioCalidad.getIndicadorDescartada()){
			notifyQualityScenarioEvaluationExecution(evaluacionEscenarioCalidad);
		}
	}

	private void notifyQualityScenarioEvaluationExecution(EvaluacionEscenarioCalidad evaluacionEscenarioCalidad) {
		QualityEvaluationAvailableEvent qualityEvaluationAvailableEvent =  null;
		qualityEvaluationAvailableEvent = new QualityEvaluationAvailableEvent();
		qualityEvaluationAvailableEvent.setEvaluacionEscenarioCalidad(evaluacionEscenarioCalidad);
		qualityAuditEvaluator.evaluateScenario(qualityEvaluationAvailableEvent);
	}
	
	private void storeSamples(List<MuestraEvaluacion> muestras) {
		for (MuestraEvaluacion muestra : muestras) {
			em.persist(muestra);
		}
	}

}
