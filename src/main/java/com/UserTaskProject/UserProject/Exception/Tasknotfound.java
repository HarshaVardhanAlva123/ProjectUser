package com.UserTaskProject.UserProject.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class Tasknotfound extends RuntimeException {
	
			private String message ;
			
			public Tasknotfound(String message)
			{
			super(message);
			}


}
