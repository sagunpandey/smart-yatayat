package com.sagunpandey.smartyatayat.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingController {

    @ExceptionHandler(LoginException.class)
    public ResponseEntity<ExceptionResponse> invalidCredentialsException(LoginException ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<ExceptionResponse> badRequestException(BadRequestException ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<ExceptionResponse> notFoundException(ResourceNotFoundException ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}