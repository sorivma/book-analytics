package com.example.bookanalytics.services;

import com.example.bookanalytics.dtos.*;

import java.util.List;

public interface AnalyticsService {
    List<GenreAnalyticsDto> analyzePurchaser(PurchaserDto purchaserDto);

    List<PublisherAnalyticsDto> analyzePublishers();

    List<BookGradeDto> currentRanking();

    List<EmailDto> getEmails(GenreDto genreDto, Integer criteria);
}
