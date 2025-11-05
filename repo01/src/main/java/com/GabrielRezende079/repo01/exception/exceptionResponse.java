package com.GabrielRezende079.repo01.exception;
import java.util.Date;

// This record represents the structure of an exception response
public record exceptionResponse(Date Timestamp, String message, String details) {
    
}
