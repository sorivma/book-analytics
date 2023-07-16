package com.example.bookanalytics.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class NoPurchaseException extends EntityNotFoundException {
    public NoPurchaseException() {
        super("There is no such purchase to leave feedback");
    }
}
