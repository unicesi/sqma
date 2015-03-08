package com.sqma.auditmodel.interfaces;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.sqma.model.vo.QualityAuditSamplePackVO;

@WebService
public interface Collector {

	@WebMethod
	void pickRawSamples(QualityAuditSamplePackVO samplePack);

}
