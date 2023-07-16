package com.example.bookanalytics.services.impl;

import com.example.bookanalytics.dtos.PurchaserDto;
import com.example.bookanalytics.repositories.PurchaserRepository;
import com.example.bookanalytics.services.PurchaserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PurchaserServiceImpl implements PurchaserService<Integer> {
    private final ModelMapper modelMapper;
    private final PurchaserRepository purchaserRepository;

    public PurchaserServiceImpl(ModelMapper modelMapper, PurchaserRepository purchaserRepository) {
        this.modelMapper = modelMapper;
        this.purchaserRepository = purchaserRepository;
    }


    @Override
    public void deletePurchaser(Integer id) {
        purchaserRepository.deleteById(id);
    }

    @Override
    public List<PurchaserDto> findAll() {
        return purchaserRepository
                .findAll()
                .stream()
                .map(purchaser -> modelMapper.map(purchaser, PurchaserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PurchaserDto> findPurchaser(Integer id) {
        return Optional.ofNullable(modelMapper.map(purchaserRepository.findById(id), PurchaserDto.class));
    }

    @Override
    public Optional<PurchaserDto> findPurchaser(String email) {
        return Optional.ofNullable(modelMapper.map(purchaserRepository.findByEmail(email), PurchaserDto.class));
    }
}
