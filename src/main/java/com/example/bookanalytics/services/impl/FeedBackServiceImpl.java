package com.example.bookanalytics.services.impl;

import com.example.bookanalytics.dtos.FeedBackDto;
import com.example.bookanalytics.dtos.PurchaseDto;
import com.example.bookanalytics.dtos.PurchaserDto;
import com.example.bookanalytics.exceptions.NoFeedBackException;
import com.example.bookanalytics.exceptions.NoPurchaseException;
import com.example.bookanalytics.exceptions.NoPurchaserException;
import com.example.bookanalytics.models.Feedback;
import com.example.bookanalytics.repositories.FeedbackRepository;
import com.example.bookanalytics.repositories.PurchaseRepository;
import com.example.bookanalytics.repositories.PurchaserRepository;
import com.example.bookanalytics.services.FeedBackService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FeedBackServiceImpl implements FeedBackService<Integer> {
    private final FeedbackRepository feedbackRepository;
    private final ModelMapper modelMapper;
    private final PurchaseRepository purchaseRepository;
    private final PurchaserRepository purchaserRepository;
    public FeedBackServiceImpl(FeedbackRepository feedbackRepository, ModelMapper modelMapper, PurchaseRepository purchaseRepository, PurchaserRepository purchaserRepository) {
        this.feedbackRepository = feedbackRepository;
        this.modelMapper = modelMapper;
        this.purchaseRepository = purchaseRepository;
        this.purchaserRepository = purchaserRepository;
    }

    @Override
    public FeedBackDto leaveFeedBack(FeedBackDto feedbackDto) {

        Feedback feedback = modelMapper.map(feedbackDto , Feedback.class);
        feedback.setPurchase(purchaseRepository.findById(feedbackDto.getPurchaseId()).orElseThrow(NoPurchaseException::new));
        return modelMapper.map(feedbackRepository.save(feedback), FeedBackDto.class);
    }

    @Override
    public void deleteFeedBack(FeedBackDto feedBackDto) {
        feedbackRepository.deleteById(feedBackDto.getId());
    }

    @Override
    public void deleteFeedBack(Integer id) {
        feedbackRepository.deleteById(id);
    }

    @Override
    public Optional<FeedBackDto> findFeedBack(FeedBackDto feedBackDto) {
        return Optional.ofNullable(modelMapper.map(feedbackRepository.findById(feedBackDto.getId()), FeedBackDto.class));
    }

    @Override
    public Optional<FeedBackDto> findFeedBack(Integer id) {
        return Optional.ofNullable(modelMapper.map(feedbackRepository.findById(id), FeedBackDto.class));
    }

    @Override
    public List<FeedBackDto> findAll() {
        return feedbackRepository
                .findAll()
                .stream()
                .map(feedback -> modelMapper.map(feedback, FeedBackDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public FeedBackDto findByPurchase(PurchaseDto purchaseDto) {
        return modelMapper.map(
                Optional.ofNullable(purchaseRepository.
                                findById(purchaseDto.getId()).orElseThrow(NoPurchaseException::new).getFeedBack())
                        .orElseThrow(NoFeedBackException::new),
                FeedBackDto.class);
    }

    @Override
    public List<FeedBackDto> findByPurchaser(PurchaserDto purchaserDto) {
        return purchaserRepository.findById(
                purchaserDto.getId())
                .orElseThrow(NoPurchaserException::new)
                .getPurchaseHistory()
                .stream()
                .filter(purchase -> purchase.getFeedBack() != null)
                .map(purchase -> modelMapper.map(purchase.getFeedBack(), FeedBackDto.class))
                .collect(Collectors.toList());
    }
}
