package com.sqma.auditmodel.components;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;

import com.sqma.auditmodel.events.QualitySamplesAvailableEvent;
import com.sqma.auditmodel.interfaces.Processor;
import com.sqma.auditmodel.interfaces.Store;
import com.sqma.auditmodel.util.exceptions.InvalidSampleScenarioException;
import com.sqma.model.EscenarioCalidad;
import com.sqma.model.MuestraEvaluacion;

@Startup
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class QualityAuditStore implements Store {

	@PersistenceContext(name = "sqmaPU")
	private EntityManager em;
	
	@Inject
	private Logger logger;
	
	@EJB
	private Processor qualityAuditProcessor;

	Map<EscenarioCalidad, List<MuestraEvaluacion>> muestrasEscenario;

	@PostConstruct
	private void intializeStore() {
		muestrasEscenario = new HashMap<EscenarioCalidad, List<MuestraEvaluacion>>();
	}

	@Override
	public void queueSamples(List<MuestraEvaluacion> muestras) {
		Set<EscenarioCalidad> escenariosCalidad = null;
		escenariosCalidad = new HashSet<EscenarioCalidad>();
		
		for (MuestraEvaluacion muestra : muestras) {
			if (!muestrasEscenario.containsKey(muestra.getEscenarioCalidad())) {
				muestrasEscenario.put(muestra.getEscenarioCalidad(),
						Collections.synchronizedList(new ArrayList<MuestraEvaluacion>()));
			}
			synchronized (muestrasEscenario.get(muestra.getEscenarioCalidad())) {
				muestrasEscenario.get(muestra.getEscenarioCalidad()).add(muestra);	
			}
			escenariosCalidad.add(muestra.getEscenarioCalidad());
		}
		checkScenariosQueues(escenariosCalidad);
	}

	private void checkScenariosQueues(Set<EscenarioCalidad> escenariosCalidad){
		Iterator<EscenarioCalidad> it = escenariosCalidad.iterator();
		while(it.hasNext()){
			checkScenarioQueue(it.next());
		}
	}
	
	private void checkScenarioQueue(EscenarioCalidad escenarioCalidad){
		List<MuestraEvaluacion> muestrasEvaluacion = null;
		Iterator<MuestraEvaluacion> it = null;
		int iteratorCounter = 0;
		int metricProcessSampleQuantity = 0;
		
		metricProcessSampleQuantity = escenarioCalidad.getMetricaCalidad().getCantidadMuestrasProceso().intValue();
		int cantidadEvaluaciones = muestrasEscenario.get(escenarioCalidad).size() / metricProcessSampleQuantity;
		
		if(cantidadEvaluaciones > 0) {
			synchronized (muestrasEscenario.get(escenarioCalidad)) {
				for(int i=0; i<cantidadEvaluaciones; i++) {
					try {
						iteratorCounter = 0;
						muestrasEvaluacion = new ArrayList<MuestraEvaluacion>();
						it = muestrasEscenario.get(escenarioCalidad).iterator();
						while (it.hasNext() && iteratorCounter < metricProcessSampleQuantity) {
							muestrasEvaluacion.add(it.next());
							it.remove();
							iteratorCounter++;
						}
						notifySampleCollection(muestrasEvaluacion);
					} catch (Exception e) {
						logger.error("Error flushing samples from scenario queue: " + escenarioCalidad.getNombre(), e);
					}
				}
			}
		}
	}
	
	@Override
	public EscenarioCalidad searchQualityScenario(Long idEscenarioCalidad) throws InvalidSampleScenarioException {
		EscenarioCalidad escenarioCalidad = null;
		Iterator<EscenarioCalidad> iterator =  muestrasEscenario.keySet().iterator();
		while(iterator.hasNext()){
			EscenarioCalidad escenarioCalidadIt = iterator.next();
			if(escenarioCalidadIt.getIdEscenarioCalidad().equals(idEscenarioCalidad)){
				escenarioCalidad = escenarioCalidadIt;
			}
		}
		escenarioCalidad = em.find(EscenarioCalidad.class, idEscenarioCalidad);
		if(escenarioCalidad == null){
			throw new InvalidSampleScenarioException("Quality scenario not found.");
		}
		return escenarioCalidad;
	}
	
	private void notifySampleCollection(List<MuestraEvaluacion> muestrasEvaluacion) {
		QualitySamplesAvailableEvent event = new QualitySamplesAvailableEvent();
		event.setMuestrasEvaluacion(muestrasEvaluacion);
		qualityAuditProcessor.processSamples(event);
	}
	
}
