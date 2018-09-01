package com.myapp.exceptions;

import org.springframework.security.core.AuthenticationException;

public class JwtTokenMissingException extends AuthenticationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7662411090677469783L;

	public JwtTokenMissingException(String msg) {
		super(msg);
	}
}