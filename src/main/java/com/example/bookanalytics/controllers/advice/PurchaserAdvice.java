package com.example.bookanalytics.controllers.advice;

import com.example.bookanalytics.controllers.responce.Response;
import com.example.bookanalytics.exceptions.NoPurchaserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PurchaserAdvice {
    @ExceptionHandler(NoPurchaserException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<Response> handleNoBookException(RuntimeException ex){
        return new ResponseEntity<>(new Response(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
