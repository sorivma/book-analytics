package com.example.bookanalytics.controllers;

import com.example.bookanalytics.dtos.PurchaserDto;
import com.example.bookanalytics.exceptions.NoPurchaserException;
import com.example.bookanalytics.services.PurchaserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchasers")
public class PurchaserController {
    private final PurchaserService<Integer> purchaserService;

    public PurchaserController(PurchaserService<Integer> purchaserService) {
        this.purchaserService = purchaserService;
    }

    @GetMapping
    Iterable<PurchaserDto> getAll() {
        return purchaserService.findAll();
    }

    @GetMapping("/{id}")
    PurchaserDto getOne(@PathVariable Integer id) {
        return purchaserService.findPurchaser(id).orElseThrow(NoPurchaserException::new);
    }

    @GetMapping("/email/{email}")
    PurchaserDto getByEmail(@PathVariable String email) {
        return purchaserService.findPurchaser(email).orElseThrow(NoPurchaserException::new);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        purchaserService.deletePurchaser(id);
    }
}
