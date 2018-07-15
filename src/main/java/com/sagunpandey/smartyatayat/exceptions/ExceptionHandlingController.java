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
}