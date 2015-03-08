package com.sqma.auditmodel.interfaces;

import com.sqma.auditmodel.events.QualityEvaluationAvailableEvent;

public interface Evaluator {

	void evaluateScenario(QualityEvaluationAvailableEvent event);

}
