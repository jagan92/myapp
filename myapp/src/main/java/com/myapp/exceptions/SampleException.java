package com.myapp.exceptions;

import com.myapp.logging.Logger;

public class SampleException extends Exception {

	private static final long serialVersionUID = 3901288427653925165L;
	private static final String CLASS_NAME = SampleException.class.getName();

	private static final String METHOD_HANDLE_EXCEPTION = "handleException";

	public SampleException() {
		super();
	}

	public SampleException(String message) {
		super(message);
	}

	public SampleException(String message, Throwable cause) {
		super(message, cause);
	}

	public static void handleException(Exception ex) {
		
	}

}
