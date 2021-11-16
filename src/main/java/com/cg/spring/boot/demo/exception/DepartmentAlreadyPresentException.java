package com.cg.spring.boot.demo.exception;

public class DepartmentAlreadyPresentException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public DepartmentAlreadyPresentException() {
		super();
	}
	
	public DepartmentAlreadyPresentException(String message) {
		super(message);
	}
}
