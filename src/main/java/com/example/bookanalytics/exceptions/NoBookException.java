package com.example.bookanalytics.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class NoBookException extends EntityNotFoundException {
    public NoBookException() {
        super("There is no such book");
    }
}
