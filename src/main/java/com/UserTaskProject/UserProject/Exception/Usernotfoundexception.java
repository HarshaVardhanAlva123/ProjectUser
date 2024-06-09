package com.UserTaskProject.UserProject.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class Usernotfoundexception extends RuntimeException {
	
	private String message;
	public Usernotfoundexception(String message)
	{
		super(message);
		this.message=message;
	}
	

}
