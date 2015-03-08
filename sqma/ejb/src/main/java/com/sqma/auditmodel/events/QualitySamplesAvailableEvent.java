package com.sqma.auditmodel.events;

import java.io.Serializable;
import java.util.List;

import com.sqma.model.MuestraEvaluacion;

public class QualitySamplesAvailableEvent implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<MuestraEvaluacion> muestrasEvaluacion;

	public List<MuestraEvaluacion> getMuestrasEvaluacion() {
		return muestrasEvaluacion;
	}

	public void setMuestrasEvaluacion(List<MuestraEvaluacion> muestrasEvaluacion) {
		this.muestrasEvaluacion = muestrasEvaluacion;
	}

}
