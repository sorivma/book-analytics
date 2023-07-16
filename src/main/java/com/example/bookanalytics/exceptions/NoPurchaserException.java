package com.example.bookanalytics.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class NoPurchaserException extends EntityNotFoundException {
    public NoPurchaserException() {
        super("No such purchaser");
    }
}
