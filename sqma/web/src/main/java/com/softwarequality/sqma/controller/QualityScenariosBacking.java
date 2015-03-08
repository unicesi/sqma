package com.softwarequality.sqma.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.sqma.business.QualityScenarioBusinessFacade;
import com.sqma.model.EscenarioCalidad;

@Named
@SessionScoped
public class QualityScenariosBacking implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<EscenarioCalidad> escenariosCalidad;
	private EscenarioCalidad escenarioCalidadSeleccionado;
	
	@EJB
	private QualityScenarioBusinessFacade qualityScenarioBusinessFacade;

	@PostConstruct
	private void init() {
		loadQualityScenarios();
	}
	
	public void selectQualityScenario(EscenarioCalidad escenarioCalidad){
		escenarioCalidadSeleccionado = escenarioCalidad;
		escenarioCalidadSeleccionado = qualityScenarioBusinessFacade.loadScenarioQualityEvaluations(escenarioCalidadSeleccionado);
	}
	
	public void loadQualityScenarios() {
		escenariosCalidad = qualityScenarioBusinessFacade.findAllQualityScenarios();
	}
	
	public void updateScenarioEvaluations(){
		int oldEvaluationCount = 0;
		int newEvaluationCount = 0;
		String message = null;
		oldEvaluationCount = escenarioCalidadSeleccionado.getEvaluacionesEscenarioCalidad().size();
		selectQualityScenario(escenarioCalidadSeleccionado);
		newEvaluationCount = escenarioCalidadSeleccionado.getEvaluacionesEscenarioCalidad().size();
		if(newEvaluationCount>oldEvaluationCount){
			message = "New evaluations found ("+ (newEvaluationCount - oldEvaluationCount) +").";
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, message, message);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		}
	}
	
	
	public List<EscenarioCalidad> getEscenariosCalidad() {
		return escenariosCalidad;
	}

	public void setEscenariosCalidad(List<EscenarioCalidad> escenariosCalidad) {
		this.escenariosCalidad = escenariosCalidad;
	}

	public EscenarioCalidad getEscenarioCalidadSeleccionado() {
		return escenarioCalidadSeleccionado;
	}

	public void setEscenarioCalidadSeleccionado(
			EscenarioCalidad escenarioCalidadSeleccionado) {
		this.escenarioCalidadSeleccionado = escenarioCalidadSeleccionado;
	}

}
