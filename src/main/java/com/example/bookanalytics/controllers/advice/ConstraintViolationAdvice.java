package com.example.bookanalytics.controllers.advice;

import com.example.bookanalytics.controllers.responce.ValidationErrorResponse;
import com.example.bookanalytics.controllers.responce.Violation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ConstraintViolationAdvice {
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationErrorResponse onConstraintValidationException(
            ConstraintViolationException e) {
        List<Violation> violations = e.getConstraintViolations()
                .stream()
                .map(constraintViolation -> new Violation(
                constraintViolation.getPropertyPath().toString(),
                constraintViolation.getMessage()
        ))
                .toList();

        return new ValidationErrorResponse(violations);
    }
}
