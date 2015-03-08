package com.sqma.auditmodel.util;
import javax.mail.internet.MimeMessage.RecipientType;

import org.codemonkey.simplejavamail.Email;
import org.codemonkey.simplejavamail.Mailer;
import org.codemonkey.simplejavamail.TransportStrategy;

import com.sqma.model.EscenarioCalidad;
import com.sqma.model.EvaluacionEscenarioCalidad;
public class EmailUtil {
	
	private static final String MAIL_SERVER = "smtp.live.com";
	private static final int MAIL_SERVER_PORT = 25;
	private static final String MAIL_USER = "camilo.palacios@hotmail.com";
	private static final String SYS_ADMINISTRATOR_NAME = "sQMA Administrator";
	private static final String MAIL_USER_PASSWORD = "ccP%890317*h";
	
	public static void sendEmail(String subject, String messsage, EscenarioCalidad escenarioCalidad) {
		Email email = new Email();
		email.setSubject(subject);
		email.setTextHTML(messsage);
		email.setFromAddress(SYS_ADMINISTRATOR_NAME, MAIL_USER);
		email.addRecipient(escenarioCalidad.getNombreResponsable(), escenarioCalidad.getCorreoResponsable(), RecipientType.TO);
		new Mailer(MAIL_SERVER, MAIL_SERVER_PORT, MAIL_USER, MAIL_USER_PASSWORD, TransportStrategy.SMTP_TLS).sendMail(email);
	}
	
	
	public static void sendServiceLevelViolationEmail(EvaluacionEscenarioCalidad evaluacionEscenarioCalidad){
		
		String subject = "Invalid sample recived";
		StringBuilder htmlMessage = null;
		
		htmlMessage = new StringBuilder();
		htmlMessage.append("We have detected a service level violation");
		htmlMessage.append("for the quality scenario <b>");
		htmlMessage.append(evaluacionEscenarioCalidad.getEscenarioCalidad().getNombre());
		htmlMessage.append("</b>, reference QME: ");
		htmlMessage.append(evaluacionEscenarioCalidad.getEscenarioCalidad().getIndicador()).append("<br/>");
		htmlMessage.append("</b>, Calculated QME: ");
		htmlMessage.append(evaluacionEscenarioCalidad.getQmeCalculado()).append("<br/>");
//		sendEmail(subject, htmlMessage.toString(), evaluacionEscenarioCalidad.getEscenarioCalidad());
	}
	
}
