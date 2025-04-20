package com.enigmacamp.loan_app_api.exception;

import com.enigmacamp.loan_app_api.dto.response.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.dao.DataIntegrityViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        String errorMessage = "Data conflict error";
        if (ex.getMostSpecificCause().getMessage().contains("duplicate key value violates unique constraint")) {
            errorMessage = "Email already exists.";
        }
        return new ResponseEntity<>(new ApiErrorResponse(HttpStatus.CONFLICT.value(), errorMessage), HttpStatus.CONFLICT);
    }
}
