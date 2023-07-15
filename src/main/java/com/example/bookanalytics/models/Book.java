package com.example.bookanalytics.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.time.Year;
import java.util.Set;

@Entity
public class Book extends BaseEntity {
    private String name;
    private String author;
    private String publisher;
    @Column(name = "year_of_publication")
    private Year year;

    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Purchase> purchases;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "book_genre",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id",
                    referencedColumnName = "id"))
    private Set<Genre> genres;

    protected Book() {

    }

    public Book(String name, String author, String publisher, Year year, Set<Purchase> purchases, Set<Genre> genres) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.purchases = purchases;
        this.genres = genres;
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

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public Set<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(Set<Purchase> purchases) {
        this.purchases = purchases;
    }
}
