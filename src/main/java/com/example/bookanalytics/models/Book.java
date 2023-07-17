package com.example.bookanalytics.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.annotations.Cascade;

import java.util.Set;

@Entity
public class Book extends BaseEntity {
    @NotEmpty
    private String name;
    @NotEmpty
    private String author;
    @NotEmpty
    private String publisher;
    @Column(name = "year_of_publication")
    @NotEmpty
    private String year;

    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Purchase> purchases;


    @OneToMany(mappedBy = "book", orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<BooksGenres> booksGenres;

    protected Book() {

    }

    public Book(String name, String author, String publisher, String year, Set<Purchase> purchases, Set<BooksGenres> booksGenres) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.purchases = purchases;
        this.booksGenres = booksGenres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }


    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Set<BooksGenres> getBooksGenres() {
        return booksGenres;
    }

    public void setBooksGenres(Set<BooksGenres> booksGenres) {
        this.booksGenres = booksGenres;
    }

    public Set<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(Set<Purchase> purchases) {
        this.purchases = purchases;
    }
}
