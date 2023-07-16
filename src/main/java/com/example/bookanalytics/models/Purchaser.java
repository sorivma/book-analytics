package com.example.bookanalytics.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import org.hibernate.annotations.Cascade;

import java.util.Set;

@Entity
public class Purchaser extends BaseEntity{
    private String name;
    private String surname;
    private String patronymic;
    private String phoneNumber;
    @Column(unique = true)
    @Email
    private String email;

    @OneToMany(mappedBy = "purchaser", orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<Purchase> purchaseHistory;

    protected Purchaser() {
    }

    public Purchaser(String name, String surname, String patronymic, String phoneNumber, String email) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Purchase> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void setPurchaseHistory(Set<Purchase> purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }

    @PreRemove
    private void preRemove(){
        for (Purchase purchase : purchaseHistory) {
            if (purchase.getBook() != null) {
                purchase.getBook().getPurchases().remove(purchase);
                purchase.setBook(null);
            }
        }
    }
}
