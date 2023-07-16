package com.example.bookanalytics.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class NoFeedBackException extends EntityNotFoundException {
    public NoFeedBackException() {
        super("There is no such feedback");
    }
}
