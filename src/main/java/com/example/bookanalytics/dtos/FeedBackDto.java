package com.example.bookanalytics.dtos;

import com.example.bookanalytics.models.Purchase;

public class FeedBackDto {
    private Integer id;
    private Integer purchaseId;
    private Integer paperQuality;
    private Integer plotOfBook;
    private Integer materialFeed;
    private Integer exteriorDesign;
    private Integer qualityOfDelivery;
    private String description;

    protected FeedBackDto() {

    }

    public FeedBackDto(Integer id, Integer purchaseId, Integer paperQuality,
                       Integer plotOfBook, Integer materialFeed, Integer exteriorDesign,
                       Integer qualityOfDelivery, String description) {
        this.id = id;
        this.purchaseId = purchaseId;
        this.paperQuality = paperQuality;
        this.plotOfBook = plotOfBook;
        this.materialFeed = materialFeed;
        this.exteriorDesign = exteriorDesign;
        this.qualityOfDelivery = qualityOfDelivery;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
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

