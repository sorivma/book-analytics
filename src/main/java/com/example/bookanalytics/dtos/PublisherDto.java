package com.example.bookanalytics.dtos;

public class PublisherDto {
    private String publisher;
    private String bookName;
    private String rating;

    public PublisherDto(String publisher, String bookName, String rating) {
        this.publisher = publisher;
        this.bookName = bookName;
        this.rating = rating;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
