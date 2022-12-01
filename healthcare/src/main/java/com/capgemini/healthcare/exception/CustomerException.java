package com.capgemini.healthcare.exception;

public class CustomerException extends RuntimeException{
	
private String message;
	
	public CustomerException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "ExceptionHandling [message=" + message + "]";
	}

}
