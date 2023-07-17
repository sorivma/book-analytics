package com.example.bookanalytics.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Feedback extends BaseEntity {
    @OneToOne(optional = false)
    private Purchase purchase;
    @Min(value = 0, message = "Grade should not be less than zero")
    @Max(value = 5, message = "Grade should not be greater than five")
    private Integer paperQuality;
    @Min(value = 0, message = "Grade should not be less than zero")
    @Max(value = 5, message = "Grade should not be greater than five")
    private Integer plotOfBook;
    @Min(value = 0, message = "Grade should not be less than zero")
    @Max(value = 5, message = "Grade should not be greater than five")
    private Integer materialFeed;
    @Min(value = 0, message = "Grade should not be less than zero")
    @Max(value = 5, message = "Grade should not be greater than five")
    private Integer exteriorDesign;
    @Min(value = 0, message = "Grade should not be less than zero")
    @Max(value = 5, message = "Grade should not be greater than five")
    private Integer qualityOfDelivery;
    @NotBlank
    private String description;

    protected Feedback() {
    }

    public Feedback(Purchase purchase, Integer paperQuality, Integer plotOfBook, Integer materialFeed, Integer exteriorDesign, Integer qualityOfDelivery, String description) {
        this.purchase = purchase;
        this.paperQuality = paperQuality;
        this.plotOfBook = plotOfBook;
        this.materialFeed = materialFeed;
        this.exteriorDesign = exteriorDesign;
        this.qualityOfDelivery = qualityOfDelivery;
        this.description = description;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Integer getPaperQuality() {
        return paperQuality;
    }

    public void setPaperQuality(Integer paperQuality) {
        this.paperQuality = paperQuality;
    }

    public Integer getPlotOfBook() {
        return plotOfBook;
    }

    public void setPlotOfBook(Integer plotOfBook) {
        this.plotOfBook = plotOfBook;
    }

    public Integer getMaterialFeed() {
        return materialFeed;
    }

    public void setMaterialFeed(Integer materialFeed) {
        this.materialFeed = materialFeed;
    }

    public Integer getExteriorDesign() {
        return exteriorDesign;
    }

    public void setExteriorDesign(Integer exteriorDesign) {
        this.exteriorDesign = exteriorDesign;
    }

    public Integer getQualityOfDelivery() {
        return qualityOfDelivery;
    }

    public void setQualityOfDelivery(Integer qualityOfDelivery) {
        this.qualityOfDelivery = qualityOfDelivery;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Feedback{" + "purchase=" + purchase + ", paperQuality=" + paperQuality + ", plotOfBook=" + plotOfBook + ", materialFeed=" + materialFeed + ", exteriorDesign=" + exteriorDesign + ", qualityOfDelivery=" + qualityOfDelivery + ", description='" + description + '\'' + '}';
    }
}
