package com.example.bookanalytics.dtos;

public class PurchaseDto {
    private Integer id;
    private Integer quantity;
    private BookDto bookDto;
    private PurchaserDto purchaserDto;

    public PurchaseDto(Integer quantity, BookDto bookDto, PurchaserDto purchaserDto) {
        this.quantity = quantity;
        this.bookDto = bookDto;
        this.purchaserDto = purchaserDto;
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
}
