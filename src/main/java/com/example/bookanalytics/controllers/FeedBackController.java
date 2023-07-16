package com.example.bookanalytics.controllers;

import com.example.bookanalytics.dtos.FeedBackDto;
import com.example.bookanalytics.exceptions.NoFeedBackException;
import com.example.bookanalytics.services.FeedBackService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feedback")
public class FeedBackController {
    private final FeedBackService<Integer> feedBackService;

    public FeedBackController(FeedBackService<Integer> feedBackService) {
        this.feedBackService = feedBackService;
    }

    @GetMapping
    Iterable<FeedBackDto> getAll() {
        return feedBackService.findAll();
    }

    @GetMapping("/{id}")
    FeedBackDto getOne(@PathVariable Integer id) {
        return feedBackService.findFeedBack(id).orElseThrow(NoFeedBackException::new);
    }

    @PostMapping
    FeedBackDto add(@RequestBody FeedBackDto feedBackDto) {
        return feedBackService.leaveFeedBack(feedBackDto);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        feedBackService.deleteFeedBack(id);
    }
}
