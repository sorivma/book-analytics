package com.example.bookanalytics.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.Set;

@Entity
public class Genre extends BaseEntity {
    private String name;
    @ManyToMany(mappedBy = "genres", targetEntity = Book.class)
    private Set<Book> books;

    protected Genre() {

    }

    public Genre(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
