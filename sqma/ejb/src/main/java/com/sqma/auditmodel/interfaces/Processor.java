package com.sqma.auditmodel.interfaces;

import com.sqma.auditmodel.events.QualitySamplesAvailableEvent;

public interface Processor {

	void processSamples(QualitySamplesAvailableEvent event);

}
