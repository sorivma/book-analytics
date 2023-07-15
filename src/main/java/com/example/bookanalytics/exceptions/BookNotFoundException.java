package com.example.bookanalytics.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class BookNotFoundException extends EntityNotFoundException {
    public BookNotFoundException() {
        super("There is no such book");
    }
}
