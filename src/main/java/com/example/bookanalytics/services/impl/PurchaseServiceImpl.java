package com.example.bookanalytics.services.impl;

import com.example.bookanalytics.dtos.PurchaseDto;
import com.example.bookanalytics.dtos.PurchaserDto;
import com.example.bookanalytics.exceptions.BookNotFoundException;
import com.example.bookanalytics.models.Book;
import com.example.bookanalytics.models.Purchase;
import com.example.bookanalytics.models.Purchaser;
import com.example.bookanalytics.repositories.BookRepository;
import com.example.bookanalytics.repositories.PurchaseRepository;
import com.example.bookanalytics.repositories.PurchaserRepository;
import com.example.bookanalytics.services.PurchaseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PurchaseServiceImpl implements PurchaseService<Integer> {
    private final PurchaserRepository purchaserRepository;
    private final PurchaseRepository purchaseRepository;
    private final ModelMapper modelMapper;
    private final BookRepository bookRepository;

    public PurchaseServiceImpl(BookRepository bookRepository, ModelMapper modelMapper, PurchaseRepository purchaseRepository, PurchaserRepository purchaserRepository) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
        this.purchaseRepository = purchaseRepository;
        this.purchaserRepository = purchaserRepository;
    }

    @Override
    @Transactional
    public PurchaseDto purchase(PurchaseDto purchaseDto) {
        Purchase purchase =  modelMapper.map(purchaseDto, Purchase.class);
        if (purchase.getPurchaser().getId() != 0) {
            Purchaser purchaser = purchaserRepository.findById(purchase.getPurchaser().getId()).get();
            purchase.setPurchaser(purchaser);
        }
        else {
            purchase.getPurchaser().setId(null);
        }
        if (purchase.getBook().getId() != 0) {
            Book book = bookRepository.findById(purchase.getBook().getId()).orElseThrow(BookNotFoundException::new);
            purchase.setBook(book);
        } else {
            throw new BookNotFoundException();
        }

        return modelMapper.map(purchaseRepository.save(purchase), PurchaseDto.class);
    }

    @Override
    public void delete(PurchaseDto purchase) {
        purchaseRepository.deleteById(purchase.getId());
    }

    @Override
    public void delete(Integer id) {
        purchaseRepository.deleteById(id);
    }

    @Override
    public Optional<PurchaseDto> findPurchase(Integer id) {
        return Optional.ofNullable(modelMapper.map(purchaseRepository.findById(id), PurchaseDto.class));
    }

    @Override
    public List<PurchaseDto> getAll() {
        return purchaseRepository
                .findAll().
                stream()
                .map(purchase -> modelMapper.map(purchase, PurchaseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PurchaseDto> findByPurchaser(PurchaserDto purchaserDto) {
        return purchaseRepository
                .findByPurchaserId(purchaserDto.getId())
                .stream().map(purchase -> modelMapper.map(purchase, PurchaseDto.class))
                .collect(Collectors.toList());
    }
}
