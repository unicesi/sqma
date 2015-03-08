package com.sqma.auditmodel.components;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.slf4j.Logger;

import com.eclipsesource.json.JsonObject;
import com.sqma.auditmodel.interfaces.Collector;
import com.sqma.auditmodel.interfaces.Store;
import com.sqma.auditmodel.util.exceptions.InvalidSampleException;
import com.sqma.auditmodel.util.exceptions.InvalidSampleStructureException;
import com.sqma.model.EscenarioCalidad;
import com.sqma.model.MedidaMetrica;
import com.sqma.model.MetricaCalidad;
import com.sqma.model.MuestraEvaluacion;
import com.sqma.model.vo.QualityAuditSamplePackVO;
import com.sqma.model.vo.QualityAuditSampleVO;

@Stateless
@WebService(serviceName = "QualityAuditCollector", endpointInterface = "com.sqma.auditmodel.interfaces.Collector")
@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,use=SOAPBinding.Use.LITERAL,parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)
public class QualityAuditCollector implements Collector {

	@EJB
	private Store qualityAuditStore;
	
	@Inject
	private Logger logger;

	@WebMethod
	public void pickRawSamples(QualityAuditSamplePackVO samplePackVO) {
		List<MuestraEvaluacion> muestras = null;
		muestras = buildSamples(samplePackVO);
		qualityAuditStore.queueSamples(muestras);
	}

	private List<MuestraEvaluacion> buildSamples(QualityAuditSamplePackVO samplePackVO) {
		List<MuestraEvaluacion> muestrasEvaluacion = null;
		muestrasEvaluacion = new ArrayList<MuestraEvaluacion>();
		for (QualityAuditSampleVO sampleVO : samplePackVO.getQualityAuditSampleVOs()) {
			try {
				muestrasEvaluacion.add(buildSample(sampleVO, samplePackVO.getCollectionDate()));
			} catch (InvalidSampleException e) {
				logger.error("Invalid sample received: " + sampleVO.getSample(), e);
			}
		}
		return muestrasEvaluacion;
	}

	private MuestraEvaluacion buildSample(QualityAuditSampleVO qualityAuditSampleVO, Calendar collectionDate)
			throws InvalidSampleException {
		MuestraEvaluacion muestraEvaluacion = null;
		EscenarioCalidad escenarioCalidad = null;
		
		escenarioCalidad = qualityAuditStore.searchQualityScenario(qualityAuditSampleVO.getIdEscenarioCalidad());
		validateRawSample(escenarioCalidad, qualityAuditSampleVO);
		muestraEvaluacion = new MuestraEvaluacion();
		muestraEvaluacion.setEscenarioCalidad(escenarioCalidad);
		muestraEvaluacion.setFechaRecepcion(collectionDate);
		muestraEvaluacion.setMuestra(qualityAuditSampleVO.getSample());
		return muestraEvaluacion;
	}

	private void validateRawSample(EscenarioCalidad escenarioCalidad, QualityAuditSampleVO qualityAuditSampleVO)
			throws InvalidSampleStructureException {
		JsonObject sampleJsonObject = null;
		List<MedidaMetrica> medidasBaseMetrica = null;
		
		sampleJsonObject = JsonObject.readFrom(qualityAuditSampleVO.getSample());
		medidasBaseMetrica = getMetricBaseMeasures(escenarioCalidad.getMetricaCalidad());
		for (MedidaMetrica medidaMetrica : medidasBaseMetrica) {
			try{
				sampleJsonObject.get(medidaMetrica.getCodigoVariable()).asDouble();	
			}catch(Exception e){
				throw new InvalidSampleStructureException("Invalid sample structure.", e);
			}
		}
	}
	
	private static final List<MedidaMetrica> getMetricBaseMeasures(MetricaCalidad metrica){
		List<MedidaMetrica> medidasBaseMetrica = null;
		medidasBaseMetrica = new ArrayList<MedidaMetrica>();
		for(MedidaMetrica medida: metrica.getMedidasMetrica()){
			if(medida.getIndicadorMedidaBase()){
				medidasBaseMetrica.add(medida);
			}
		}
		return medidasBaseMetrica;
	}

}
