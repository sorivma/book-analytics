package com.example.bookanalytics.controllers;

import com.example.bookanalytics.dtos.FeedBackDto;
import com.example.bookanalytics.dtos.PurchaseDto;
import com.example.bookanalytics.exceptions.NoPurchaseException;
import com.example.bookanalytics.services.FeedBackService;
import com.example.bookanalytics.services.PurchaseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    private final PurchaseService<Integer> purchaseService;
    private final FeedBackService<Integer> feedBackService;
    public PurchaseController(PurchaseService<Integer> purchaseService, FeedBackService<Integer> feedBackService) {
        this.purchaseService = purchaseService;
        this.feedBackService = feedBackService;
    }

    @GetMapping
    Iterable<PurchaseDto> getAll() {
        return purchaseService.getAll();
    }

    @GetMapping("/{id}")
    PurchaseDto getOne(@PathVariable Integer id) {
        return purchaseService.findPurchase(id).orElseThrow(NoPurchaseException::new);
    }

    @GetMapping("/feedback")
    FeedBackDto getFeedBack(@RequestBody PurchaseDto purchaseDto) {
        return feedBackService.findByPurchase(purchaseDto);
    }

    @PostMapping
    PurchaseDto addPurchase(@RequestBody PurchaseDto purchaseDto) {
        return purchaseService.purchase(purchaseDto);
    }

    @DeleteMapping("/{id}")
    void deletePurchase(@PathVariable Integer id) {
        purchaseService.delete(id);
    }
}
