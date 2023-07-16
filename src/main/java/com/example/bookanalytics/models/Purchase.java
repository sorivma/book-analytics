package com.example.bookanalytics.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;

import java.util.Date;

@Entity
@Table(name = "purchase_history")
public class Purchase extends BaseEntity {
    @ManyToOne(optional = false, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "purchaser_id", referencedColumnName = "id", nullable = false)
    private Purchaser purchaser;
    @ManyToOne(optional = false)
    @JoinColumn(name = "book_id", referencedColumnName = "id", nullable = false)
    private Book book;
    @OneToOne(mappedBy = "purchase", targetEntity = Feedback.class, cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private Feedback feedBack;
    private Date date;
    private Integer quantity;

    protected Purchase() {

    }

    public Purchase(Purchaser purchaser, Book book, Feedback feedBack, Date date, Integer quantity) {
        this.purchaser = purchaser;
        this.book = book;
        this.feedBack = feedBack;
        this.date = date;
        this.quantity = quantity;
    }

    public Purchaser getPurchaser() {
        return purchaser;
    }

    public void setPurchaser(Purchaser purchaser) {
        this.purchaser = purchaser;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Feedback getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(Feedback feedBack) {
        this.feedBack = feedBack;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @PreRemove
    private void preRemove() {
        book.getPurchases().remove(this);
        book = null;
    }
}
