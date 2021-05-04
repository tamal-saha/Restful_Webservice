package com.RestfulWebservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8995961631224382555L;
	public UserNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
