package com.example.bookanalytics.models;

import jakarta.persistence.*;

@Entity
@Table(name = "book_genre")
public class BooksGenres extends BaseEntity{
    @ManyToOne(optional = false)
    private Book book;
    @ManyToOne(optional = false)
    private Genre genre;

    protected BooksGenres() {

    }
    public BooksGenres(Book book, Genre genre) {
        this.book = book;
        this.genre = genre;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
