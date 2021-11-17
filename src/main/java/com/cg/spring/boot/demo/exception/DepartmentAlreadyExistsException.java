package com.cg.spring.boot.demo.exception;

public class DepartmentAlreadyExistsException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public DepartmentAlreadyExistsException() {
		super();
	}
	
	public DepartmentAlreadyExistsException(String message) {
		super(message);
	}
}
