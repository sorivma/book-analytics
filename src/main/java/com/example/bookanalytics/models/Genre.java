package com.example.bookanalytics.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

@Entity
public class Genre extends BaseEntity {
    @NotBlank
    private String name;
    @OneToMany(mappedBy = "genre", orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<BooksGenres> booksGenres;

    protected Genre() {

    }

    public Genre(String name, Set<BooksGenres> booksGenres) {
        this.name = name;
        this.booksGenres = booksGenres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<BooksGenres> getBooksGenres() {
        return booksGenres;
    }

    public void setBooksGenres(Set<BooksGenres> booksGenres) {
        this.booksGenres = booksGenres;
    }
}
