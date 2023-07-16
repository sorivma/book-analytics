package com.example.bookanalytics.services;

import com.example.bookanalytics.dtos.BookDto;
import com.example.bookanalytics.dtos.GenreDto;
import com.example.bookanalytics.models.Genre;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface BookService<ID> {
    BookDto addBook(BookDto bookDto);

    Optional<BookDto> findBook(ID id);

    List<BookDto> findAll();

    List<BookDto> findPublisherBooks(String publisher);

    List<BookDto> findBooks(GenreDto genres);
}