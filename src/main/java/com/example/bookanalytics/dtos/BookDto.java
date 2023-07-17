package com.example.bookanalytics.dtos;

import jakarta.validation.constraints.NotNull;

import java.util.Set;

public class BookDto {
    private Integer id;
    private String name;
    private String publisher;
    private String author;
    private Set<GenreDto> genres;
    private String year;

    public BookDto(Integer id, String name,
                    String publisher,
                    String author,
                    Set<GenreDto> genres,
                    String year) {
        this.id = id;
        this.name = name;
        this.publisher = publisher;
        this.author = author;
        this.genres = genres;
        this.year = year;
    }

    protected BookDto() {
    }
    @NotNull
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    public Set<GenreDto> getGenres() {
        return genres;
    }

    public void setGenres(Set<GenreDto> genres) {
        this.genres = genres;
    }
    @NotNull
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
