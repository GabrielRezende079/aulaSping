package com.GabrielRezende079.repo01.exception.handler;

import com.GabrielRezende079.repo01.exception.UnsupportedMathOperationException;
import com.GabrielRezende079.repo01.exception.exceptionResponse;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;


@RestController
@ControllerAdvice // This annotation allows the class to handle exceptions globally across all controllers
public class customEntityResponseHandler extends ResponseEntityExceptionHandler {

    // this method handles all generic exceptions that are not specifically handled elsewhere
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<exceptionResponse>handleAllExceptions(Exception ex, WebRequest request){
        exceptionResponse response = new exceptionResponse(
            new Date(),
            ex.getMessage(),
            request.getDescription(false)
            );
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    } 

    // this method handles UnsupportedMathOperationException specifically
    @ExceptionHandler(UnsupportedMathOperationException.class)
    public final ResponseEntity<exceptionResponse>handleBadRequestExceptions(Exception ex, WebRequest request){
        exceptionResponse response = new exceptionResponse(
            new Date(),
            ex.getMessage(),
            request.getDescription(false)
            );
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    } 
}
