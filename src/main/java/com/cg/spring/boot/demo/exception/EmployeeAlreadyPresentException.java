package com.cg.spring.boot.demo.exception;

public class EmployeeAlreadyPresentException extends RuntimeException{
	

	private static final long serialVersionUID = 1L;

	public EmployeeAlreadyPresentException() {
		super();
	}
	
	public EmployeeAlreadyPresentException(String message) {
		super(message);
	}
	
	
}
