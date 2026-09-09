package com.appointment.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(
            ResourceNotFoundException ex) {

        ErrorResponse error = new ErrorResponse(
                404,
                ex.getMessage()
        );

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationException(
            MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error ->
                        errors.put(
                                error.getField(),
                                error.getDefaultMessage()
                        )
                );

        Map<String, Object> response = new HashMap<>();

        response.put("status", 400);
        response.put("message", "Validation failed");
        response.put("errors", errors);

        return ResponseEntity
                .badRequest()
                .body(response);
    }

    @ExceptionHandler(AppointmentAlreadyBookedException.class)
    public ResponseEntity<ErrorResponse> handleAppointmentAlreadyBooked(
            AppointmentAlreadyBookedException ex) {

        ErrorResponse error = new ErrorResponse(
                409,
                ex.getMessage()
        );

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(error);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(
            IllegalArgumentException ex) {

        ErrorResponse error = new ErrorResponse(
                400,
                ex.getMessage()
        );

        return ResponseEntity.status(400).body(error);
    }
}