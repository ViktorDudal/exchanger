package com.exchanger.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.Collections;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException exception) {
        ErrorResponse errorResponse = new ErrorResponse(Instant.now(), exception.getMessage(), Collections.emptyList());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}
