package com.example.bookanalytics.services;

import com.example.bookanalytics.dtos.PurchaseDto;
import com.example.bookanalytics.dtos.PurchaserDto;

import java.util.List;
import java.util.Optional;

public interface PurchaseService <ID>{
    PurchaseDto purchase(PurchaseDto purchase);
    void delete(PurchaseDto purchase);
    void delete(ID id);
    Optional<PurchaseDto> findPurchase(ID id);
    List<PurchaseDto> getAll();
    List<PurchaseDto> findByPurchaser(PurchaserDto purchaserDto);

}
