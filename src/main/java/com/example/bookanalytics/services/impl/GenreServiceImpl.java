package com.example.bookanalytics.services.impl;

import com.example.bookanalytics.dtos.GenreDto;
import com.example.bookanalytics.models.Genre;
import com.example.bookanalytics.repositories.GenreRepository;
import com.example.bookanalytics.services.GenreService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GenreServiceImpl implements GenreService<Integer> {
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public GenreDto addGenre(GenreDto genre) {
        return modelMapper.map(
                genreRepository.save(modelMapper.map(genre, Genre.class)), GenreDto.class);
    }

    @Override
    public List<GenreDto> findAll() {
        return genreRepository.findAll()
                .stream()
                .map(genre -> modelMapper.map(genre, GenreDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<GenreDto> findById(Integer id) {
        return Optional.ofNullable(modelMapper.map(genreRepository.findById(id), GenreDto.class));
    }

}
