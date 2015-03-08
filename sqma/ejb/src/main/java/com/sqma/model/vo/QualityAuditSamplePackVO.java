package com.sqma.model.vo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

public class QualityAuditSamplePackVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Calendar collectionDate;

	private List<QualityAuditSampleVO> qualityAuditSampleVOs;

	public Calendar getCollectionDate() {
		return collectionDate;
	}

	public void setCollectionDate(Calendar collectionDate) {
		this.collectionDate = collectionDate;
	}

	public List<QualityAuditSampleVO> getQualityAuditSampleVOs() {
		return qualityAuditSampleVOs;
	}

	public void setQualityAuditSampleVOs(
			List<QualityAuditSampleVO> qualityAuditSampleVOs) {
		this.qualityAuditSampleVOs = qualityAuditSampleVOs;
	}

}
