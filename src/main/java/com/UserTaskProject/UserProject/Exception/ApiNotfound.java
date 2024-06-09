package com.UserTaskProject.UserProject.Exception;

public class ApiNotfound  extends RuntimeException{

	private String message;
	public ApiNotfound(String message)
	{
		super(message);
	}
	
}
