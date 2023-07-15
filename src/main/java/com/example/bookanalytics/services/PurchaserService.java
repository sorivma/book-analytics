package com.example.bookanalytics.services;

import com.example.bookanalytics.dtos.GenreDto;
import com.example.bookanalytics.dtos.PurchaserDto;

import java.util.List;
import java.util.Optional;

public interface PurchaserService {
    void delete(PurchaserDto purchaserDto);
    void delete(String email);
    Optional<PurchaserDto> findPurchaserByEmail(String email);
    Optional<List<GenreDto>> findGenresRating(String email);
}
