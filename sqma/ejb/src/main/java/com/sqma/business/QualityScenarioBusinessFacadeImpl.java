package com.sqma.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.sqma.model.EscenarioCalidad;

@Stateless
public class QualityScenarioBusinessFacadeImpl implements QualityScenarioBusinessFacade {

	@PersistenceContext(name="sqmaPU")
	private EntityManager em;
	
	@Override
	public List<EscenarioCalidad> findAllQualityScenarios() {
		List<EscenarioCalidad> escenariosCalidad = null;
		TypedQuery<EscenarioCalidad> tq = em.createNamedQuery("EscenarioCalidad.findAll", EscenarioCalidad.class);
		escenariosCalidad = tq.getResultList();
		return escenariosCalidad;
	}
	
	@Override
	public EscenarioCalidad loadScenarioQualityEvaluations(EscenarioCalidad escenarioCalidad) {
		escenarioCalidad = em.find(EscenarioCalidad.class, escenarioCalidad.getIdEscenarioCalidad());
		escenarioCalidad.getEvaluacionesEscenarioCalidad().size();
		return escenarioCalidad;
	}

}
