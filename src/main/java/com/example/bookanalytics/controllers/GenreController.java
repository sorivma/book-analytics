package com.example.bookanalytics.controllers;

import com.example.bookanalytics.dtos.GenreDto;
import com.example.bookanalytics.exceptions.NoGenreException;
import com.example.bookanalytics.services.GenreService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/genres")
public class GenreController {
    private final GenreService<Integer> genreService;

    public GenreController(GenreService<Integer> genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    Iterable<GenreDto> getAll() {
        return genreService.findAll();
    }

    @GetMapping("/{id}")
    GenreDto getOne(@PathVariable Integer id) {
        return genreService.findById(id).orElseThrow(NoGenreException::new);
    }

    @PostMapping
    GenreDto addGenre(@RequestBody GenreDto genreDto) {
        return genreService.addGenre(genreDto);
    }
}
