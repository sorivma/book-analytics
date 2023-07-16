package com.example.bookanalytics.controllers;

import com.example.bookanalytics.dtos.BookDto;
import com.example.bookanalytics.exceptions.NoBookException;
import com.example.bookanalytics.services.BookService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/books")
public class BookController {
    private final BookService<Integer> bookService;


    public BookController(BookService<Integer> bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    Iterable<BookDto> getAll() {
        return bookService.findAll();
    }
    @GetMapping("/{id}")
    BookDto getOne(@PathVariable Integer id) {
        return bookService.findBook(id).orElseThrow(NoBookException::new);
    }
    @PostMapping
    BookDto addBook(@RequestBody BookDto bookDto) {
        return bookService.addBook(bookDto);
    }
}
