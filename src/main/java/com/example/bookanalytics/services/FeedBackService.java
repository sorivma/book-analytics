package com.example.bookanalytics.services;

import com.example.bookanalytics.dtos.FeedBackDto;
import com.example.bookanalytics.dtos.PurchaseDto;
import com.example.bookanalytics.dtos.PurchaserDto;

import java.util.List;
import java.util.Optional;

public interface FeedBackService<ID> {
    FeedBackDto leaveFeedBack(FeedBackDto feedBack);

    void deleteFeedBack(FeedBackDto feedBackDto);

    void deleteFeedBack(ID id);

    Optional<FeedBackDto> findFeedBack(FeedBackDto feedBackDto);

    Optional<FeedBackDto> findFeedBack(ID id);

    List<FeedBackDto> findAll();

    FeedBackDto findByPurchase(PurchaseDto purchaseDto);

    List<FeedBackDto> findByPurchaser(PurchaserDto purchaserDto);
}
