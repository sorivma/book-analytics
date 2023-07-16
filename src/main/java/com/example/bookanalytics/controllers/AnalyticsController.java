package com.example.bookanalytics.controllers;

import com.example.bookanalytics.dtos.*;
import com.example.bookanalytics.services.AnalyticsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {
    private final AnalyticsService analyticsService;

    public AnalyticsController(AnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }

    @GetMapping("/purchaser")
    List<GenreAnalyticsDto> getPurchaserAnalytics(@RequestBody PurchaserDto purchaserDto) {
        return analyticsService.analyzePurchaser(purchaserDto);
    }

    @GetMapping("/publishers")
    List<PublisherAnalyticsDto> getPublisherAnalytics() {
        return analyticsService.analyzePublishers();
    }

    @GetMapping("/rating")
    List<BookGradeDto> getRating() {
        return analyticsService.currentRanking();
    }

    @GetMapping("/emails/{criteria}")
    List<EmailDto> getEmails(@PathVariable Integer criteria, @RequestBody GenreDto genreDto) {
        return analyticsService.getEmails(genreDto, criteria);
    }
}
