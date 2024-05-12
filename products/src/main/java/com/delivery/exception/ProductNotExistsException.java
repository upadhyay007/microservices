package com.delivery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProductNotExistsException extends RuntimeException {
	public ProductNotExistsException(String message) {
		super(message);
	}
}
