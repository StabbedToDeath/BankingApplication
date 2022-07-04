package com.learning.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ResourceNotFoundException extends RuntimeException{
	

	public ResourceNotFoundException() {
		super("Resource Not Found");
	}
	public ResourceNotFoundException(String msg) {
		super(msg);
	}
	
	
}
