package com.myapp.exceptions;

import org.springframework.security.core.AuthenticationException;

public class JwtTokenMalformedException extends AuthenticationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8380809789128451603L;

	public JwtTokenMalformedException(String msg) {
		super(msg);
	}
}