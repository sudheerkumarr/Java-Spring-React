package com.cg.springboottdddemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class ProjectNotFoundException extends RuntimeException {

	public ProjectNotFoundException() {
		// TODO Auto-generated constructor stub
	}
}
