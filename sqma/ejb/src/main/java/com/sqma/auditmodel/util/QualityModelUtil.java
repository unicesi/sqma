package com.sqma.auditmodel.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sqma.model.MuestraEvaluacion;
import com.sqma.model.ParametroEscenarioCalidad;

public class QualityModelUtil {

	public static Map<String, BigDecimal> buildMetricParameters(List<ParametroEscenarioCalidad> parametrosEscenarioCalidad){
		Map<String, BigDecimal> metricParameters = null;
		metricParameters = new HashMap<String, BigDecimal>();
		String parameterKey = null;
		BigDecimal parameterValue = null;
		
		if(parametrosEscenarioCalidad != null){
			for (ParametroEscenarioCalidad parametroEscenario : parametrosEscenarioCalidad) {
				parameterKey = parametroEscenario.getMedidaMetrica().getCodigoVariable();
				parameterValue = parametroEscenario.getValorParametro();
				metricParameters.put(parameterKey, parameterValue);
			}
		}
		return metricParameters;
	}
	
	public static List<String> getSamplesAsStringArray(List<MuestraEvaluacion> muestrasEvaluacion){
		List<String> samples = null;
		
		samples = new ArrayList<String>();
		if(muestrasEvaluacion != null){
			for (MuestraEvaluacion muestraEvaluacion : muestrasEvaluacion) {
				samples.add(muestraEvaluacion.getMuestra());
			}
		}
		return samples;
	}
}
