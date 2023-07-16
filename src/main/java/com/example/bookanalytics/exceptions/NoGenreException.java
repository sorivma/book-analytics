package com.example.bookanalytics.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class NoGenreException extends EntityNotFoundException {
    public NoGenreException() {
        super("There is no such genre");
    }
}
