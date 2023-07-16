package com.example.bookanalytics.dtos;

public class PublisherAnalyticsDto {
    private String publisher;
    private Integer quantity;
    private String bestsellerName;

    protected PublisherAnalyticsDto(){
    }

    public PublisherAnalyticsDto(String publisher, Integer quantity, String bestsellerName) {
        this.publisher = publisher;
        this.quantity = quantity;
        this.bestsellerName = bestsellerName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getBestsellerName() {
        return bestsellerName;
    }

    public void setBestsellerName(String bestsellerName) {
        this.bestsellerName = bestsellerName;
    }

    @Override
    public String toString() {
        return "PublisherAnalyticsDto{" +
                "publisher='" + publisher + '\'' +
                ", quantity=" + quantity +
                ", bestsellerName='" + bestsellerName + '\'' +
                '}';
    }
}
