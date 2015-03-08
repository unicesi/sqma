package com.sqma.auditmodel.util;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sqma.auditmodel.util.exceptions.ScriptExcecutionException;

public class GroovyUtil {

	public static BigDecimal executeProcessMetricGroovyFunction(String fuctionScript,
			List<String> rawSamples, Map<String, BigDecimal> metricParameters)
			throws ScriptExcecutionException {
		BigDecimal result = null;
		Iterator<String> parametersKeysIt = null;
		Binding binding = null;
		GroovyShell shell = null;

		try {
			binding = new Binding();
			binding.setVariable("rawSamples",rawSamples);
			if (!metricParameters.isEmpty()) {
				parametersKeysIt = metricParameters.keySet().iterator();
				while (parametersKeysIt.hasNext()) {
					binding.setVariable(parametersKeysIt.next(),
							metricParameters.get(parametersKeysIt.next()));
				}
			}
			shell = new GroovyShell(binding);
			result = (BigDecimal) shell.evaluate(fuctionScript);
		} catch (Exception e) {
			throw new ScriptExcecutionException("Script excecution failure.", e);
		}
		return result;
	}
	
	
	public static Boolean executeAnalysisMetricGroovyFunction(String fuctionScript,
			BigDecimal referenceQME, BigDecimal evaluationQME, Map<String, BigDecimal> metricParameters)
			throws ScriptExcecutionException {
		Boolean result = null;
		Iterator<String> parametersKeysIt = null;
		Binding binding = null;
		GroovyShell shell = null;

		try {
			binding = new Binding();
			binding.setVariable("referenceQME",referenceQME);
			binding.setVariable("evaluationQME",evaluationQME);
			if (!metricParameters.isEmpty()) {
				parametersKeysIt = metricParameters.keySet().iterator();
				while (parametersKeysIt.hasNext()) {
					binding.setVariable(parametersKeysIt.next(),
							metricParameters.get(parametersKeysIt.next()));
				}
			}
			shell = new GroovyShell(binding);
			result = (Boolean) shell.evaluate(fuctionScript);
		} catch (Exception e) {
			throw new ScriptExcecutionException("Script excecution failure.", e);
		}
		return result;
	}
	
	
	
}
