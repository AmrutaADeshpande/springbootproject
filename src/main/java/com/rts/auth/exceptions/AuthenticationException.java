package com.rts.auth.exceptions;

public class AuthenticationException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 632824147800774282L;
	
	private Integer errorCode;
	
	public AuthenticationException(Integer errorCode, String errorMessage) {
		super(errorMessage);
		this.errorCode = errorCode;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

}
