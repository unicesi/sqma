package com.sqma.auditmodel.util.exceptions;

public class ScriptExcecutionException extends Exception {

	private static final long serialVersionUID = 1L;

	public ScriptExcecutionException() {
		super();
	}

	public ScriptExcecutionException(String message) {
		super(message);
	}

	public ScriptExcecutionException(String message, Throwable cause) {
		super(message, cause);
	}

}
