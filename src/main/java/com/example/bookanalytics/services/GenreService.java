package com.example.bookanalytics.services;

import com.example.bookanalytics.dtos.GenreDto;

import java.util.List;
import java.util.Optional;

public interface GenreService<ID> {
    GenreDto addGenre(GenreDto genre);
    List<GenreDto> findAll();
    Optional<GenreDto> findById(ID id);
}
