package com.cg.spring.boot.demo.exception;

public class NoEmployeesFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public NoEmployeesFoundException() {
		super();
	}
	
	public NoEmployeesFoundException(String message) {
		super(message);
	}
}
