package com.manish.sms.execptions;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidArgumentException extends BindException {

	private static final long serialVersionUID = 1L;

	public InvalidArgumentException(BindingResult message) {
		super(message);
	}
}
