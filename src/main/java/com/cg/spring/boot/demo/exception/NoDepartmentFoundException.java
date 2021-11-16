package com.cg.spring.boot.demo.exception;

public class NoDepartmentFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public NoDepartmentFoundException() {
		super();
	}
	
	public NoDepartmentFoundException(String message) {
		super(message);
	}

}
