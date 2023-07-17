package com.example.bookanalytics.services.impl;

import com.example.bookanalytics.dtos.BookDto;
import com.example.bookanalytics.dtos.GenreDto;
import com.example.bookanalytics.exceptions.NoGenreException;
import com.example.bookanalytics.models.Book;
import com.example.bookanalytics.models.BooksGenres;
import com.example.bookanalytics.models.Genre;
import com.example.bookanalytics.repositories.BookRepository;
import com.example.bookanalytics.repositories.GenreRepository;
import com.example.bookanalytics.services.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService<Integer> {
    private final BookRepository bookRepository;
    private final GenreRepository genreRepository;
    private final ModelMapper modelMapper;

    public BookServiceImpl(BookRepository bookRepository, GenreRepository genreRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public BookDto addBook(BookDto bookDto) {
        Book book = modelMapper.map(bookDto, Book.class);
        Set<BooksGenres> booksGenres = new HashSet<>();
        for (GenreDto genreDto : bookDto.getGenres()) {
            if (genreDto.getId() == 0 || !genreRepository.existsById(genreDto.getId())) {
                throw new NoGenreException();
            }
            booksGenres.add(new BooksGenres(book, modelMapper.map(genreDto, Genre.class)));
        }
        book.setBooksGenres(booksGenres);

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
