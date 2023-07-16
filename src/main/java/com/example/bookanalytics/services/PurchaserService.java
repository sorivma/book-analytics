package com.example.bookanalytics.services;

import com.example.bookanalytics.dtos.PurchaserDto;

import java.util.List;
import java.util.Optional;

public interface PurchaserService<ID> {
    void deletePurchaser(ID id);
    List<PurchaserDto> findAll();
    Optional<PurchaserDto> findPurchaser(ID id);
    Optional<PurchaserDto> findPurchaser(String email);

}
