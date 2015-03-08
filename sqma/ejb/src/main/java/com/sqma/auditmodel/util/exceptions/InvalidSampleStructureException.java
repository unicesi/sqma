package com.sqma.auditmodel.util.exceptions;

public class InvalidSampleStructureException extends InvalidSampleException {

	private static final long serialVersionUID = 1L;

	public InvalidSampleStructureException() {
		super();
	}

	public InvalidSampleStructureException(String message) {
		super(message);
	}

	public InvalidSampleStructureException(String message, Throwable cause) {
		super(message, cause);
	}

}
