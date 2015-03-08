package com.sqma.auditmodel.util.exceptions;

public class InvalidSampleException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidSampleException() {
		super();
	}

	public InvalidSampleException(String message) {
		super(message);
	}

	public InvalidSampleException(String message, Throwable cause) {
		super(message, cause);
	}

}
