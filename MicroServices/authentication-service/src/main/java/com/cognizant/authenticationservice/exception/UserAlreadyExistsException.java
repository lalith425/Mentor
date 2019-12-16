package com.cognizant.authenticationservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "User already exists. Try another username")
public class UserAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(UserAlreadyExistsException.class);

	public UserAlreadyExistsException() {
		LOGGER.info("User Already Exists");
	}

}
