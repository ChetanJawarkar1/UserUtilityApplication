package com.cj.globleExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.REQUEST_TIMEOUT)
public class Token_Exception extends RuntimeException {

	public Token_Exception(String msg) {
		super(msg);
	}
}
