package com.example.bookanalytics.dtos;

public class EmailDto {
    private String email;
    private String name;
    private Integer quantity;

    protected EmailDto() {

    }

    public EmailDto(String email, String name, Integer quantity) {
        this.email = email;
        this.name = name;
        this.quantity = quantity;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "EmailDto{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
