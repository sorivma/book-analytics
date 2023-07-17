package com.example.bookanalytics.dtos;

import java.util.Date;

public class PurchaseDto {
    private Integer id;
    private Integer quantity;
    private BookDto bookDto;
    private PurchaserDto purchaserDto;
    private Date date;

    public PurchaseDto(Integer id, Integer quantity, BookDto bookDto, PurchaserDto purchaserDto, Date date) {
        this.id = id;
        this.quantity = quantity;
        this.bookDto = bookDto;
        this.purchaserDto = purchaserDto;
        this.date = date;
    }

    protected PurchaseDto() {

    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BookDto getBookDto() {
        return bookDto;
    }

    public void setBookDto(BookDto bookDto) {
        this.bookDto = bookDto;
    }

    public PurchaserDto getPurchaserDto() {
        return purchaserDto;
    }

    public void setPurchaserDto(PurchaserDto purchaserDto) {
        this.purchaserDto = purchaserDto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
