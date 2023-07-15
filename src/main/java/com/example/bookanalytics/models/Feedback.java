package com.example.bookanalytics.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class Feedback extends BaseEntity {
    @OneToOne(optional = false)
    private Purchase purchase;
    private Integer paperQuality;
    private Integer plotOfBook;
    private Integer materialFeed;
    private Integer exteriorDesign;
    private Integer qualityOfDelivery;
    private String description;

    protected Feedback() {
    }

    public Feedback(
            Purchase purchase,
            Integer paperQuality,
            Integer plotOfBook,
            Integer materialFeed,
            Integer exteriorDesign,
            Integer qualityOfDelivery,
            String description) {
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
}
