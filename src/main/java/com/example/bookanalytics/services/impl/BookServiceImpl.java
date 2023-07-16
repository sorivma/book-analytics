package com.example.bookanalytics.services.impl;

import com.example.bookanalytics.dtos.BookDto;
import com.example.bookanalytics.dtos.GenreDto;
import com.example.bookanalytics.models.Book;
import com.example.bookanalytics.models.Genre;
import com.example.bookanalytics.repositories.BookRepository;
import com.example.bookanalytics.services.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService<Integer> {
    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    public BookServiceImpl(BookRepository bookRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public BookDto addBook(BookDto bookDto) {
        Book book = modelMapper.map(bookDto, Book.class);
        return modelMapper.map(bookRepository.save(book), BookDto.class);
    }

    @Override
    public Optional<BookDto> findBook(Integer id) {
        return Optional.ofNullable(modelMapper.map(bookRepository.findById(id), BookDto.class));
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository
                .findAll()
                .stream()
                .map(book -> modelMapper.map(book, BookDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDto> findPublisherBooks(String publisher) {
        return bookRepository.findAllByPublisher(publisher)
                .stream()
                .map((book -> modelMapper.map(book, BookDto.class)))
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDto> findBooks(GenreDto genre) {
        return bookRepository.findAllByGenre(modelMapper.map(genre, Genre.class))
                .stream()
                .map(book -> modelMapper.map(book, BookDto.class))
                .collect(Collectors.toList());
    }
}
