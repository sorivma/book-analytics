package com.example.bookanalytics.dtos;

import com.example.bookanalytics.models.Genre;

import java.util.List;

public class GenreAnalyticsDto {
    private String genreName;
    private Integer quantity;

    public GenreAnalyticsDto(String genreName, Integer quantity) {
        this.genreName = genreName;
        this.quantity = quantity;
    }

    protected GenreAnalyticsDto(){

    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "GenreAnalyticsDto{" +
                "genreName='" + genreName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
