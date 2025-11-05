package com.GabrielRezende079.repo01.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


// This annotation sets the HTTP status code to 400 Bad Request when this exception is thrown
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UnsupportedMathOperationException extends RuntimeException {

    // Serial version UID for serialization
    private static final long serialVersionUID = 1L;

    // Constructor that accepts a message
    public UnsupportedMathOperationException(String message) {
        super(message);
    }
}

