package com.cg.spring.boot.demo.exception;

public class AppUserAlreadyExistsException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public AppUserAlreadyExistsException() {
		super();
	}
	
	public AppUserAlreadyExistsException(String message) {
		super(message);
	}

}
