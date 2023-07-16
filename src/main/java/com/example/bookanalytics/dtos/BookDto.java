package com.example.bookanalytics.dtos;

import com.example.bookanalytics.models.Genre;

import java.util.Set;

public class BookDto {
    private Integer id;
    private String name;
    private String publisher;
    private String author;
    private Set<GenreDto> genres;
    public BookDto(Integer id, String name, String publisher, String author, Set<GenreDto> genres) {
        this.id = id;
        this.name = name;
        this.publisher = publisher;
        this.author = author;
        this.genres = genres;
    }

    protected BookDto() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<GenreDto> getGenres() {
        return genres;
    }

    public void setGenres(Set<GenreDto> genres) {
        this.genres = genres;
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
