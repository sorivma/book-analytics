package com.example.bookanalytics.services.impl;

import com.example.bookanalytics.exceptions.NoGenreException;
import com.example.bookanalytics.dtos.*;
import com.example.bookanalytics.exceptions.NoPurchaserException;
import com.example.bookanalytics.models.Book;
import com.example.bookanalytics.models.BooksGenres;
import com.example.bookanalytics.models.Genre;
import com.example.bookanalytics.models.Purchase;
import com.example.bookanalytics.repositories.*;
import com.example.bookanalytics.services.AnalyticsService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AnalyticsServiceImpl implements AnalyticsService {
    private final PurchaserRepository purchaserRepository;
    private final BookRepository bookRepository;
    private final GenreRepository genreRepository;
    private final FeedbackRepository feedbackRepository;

    public AnalyticsServiceImpl(PurchaserRepository purchaserRepository, BookRepository bookRepository, GenreRepository genreRepository, FeedbackRepository feedbackRepository) {
        this.purchaserRepository = purchaserRepository;
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public List<GenreAnalyticsDto> analyzePurchaser(PurchaserDto purchaserDto) {
        if (!purchaserRepository.existsById(purchaserDto.getId())) {
            throw new NoPurchaserException();
        }


        List<Genre> genres = genreRepository.findAll();
        List<GenreAnalyticsDto> genreAnalytics = new ArrayList<>();
        for (Genre genre : genres) {
            List<Book> books = bookRepository.findAllByGenre(genre);
            GenreAnalyticsDto genreAnalyticsDto = new GenreAnalyticsDto(genre.getName(), 0);
            for (Book book : books) {
                Set<Purchase> purchases = book.getPurchases();
                for (Purchase purchase : purchases) {
                    if (Objects.equals(purchase.getPurchaser().getId(), purchaserDto.getId())) {
                        genreAnalyticsDto.setQuantity(genreAnalyticsDto.getQuantity() + purchase.getQuantity());
                    }
                }
            }
            genreAnalytics.add(genreAnalyticsDto);
        }

        genreAnalytics.sort((Comparator.comparing(GenreAnalyticsDto::getQuantity)));

        return genreAnalytics;
    }

    @Override
    public List<PublisherAnalyticsDto> analyzePublishers() {
        List<String> publishers = bookRepository.findAllPublishers();
        List<PublisherAnalyticsDto> publisherAnalytics = new ArrayList<>();
        for (String publisher : publishers) {
            publisherAnalytics.add(new PublisherAnalyticsDto(publisher,
                    bookRepository.findTotalQuantity(publisher),
                    bookRepository.findBestSeller(publisher)));
        }
        return publisherAnalytics;
    }

    @Override
    public List<BookGradeDto> currentRanking() {
        List<Book> books = bookRepository.findAll();
        List<BookGradeDto> bookGrades = new ArrayList<>();
        for (Book book : books){
            bookGrades.add(new BookGradeDto(book.getName(), feedbackRepository.getAvgRating(book.getId()).orElse(0.0)));
        }

        bookGrades.sort(Comparator.comparing(BookGradeDto::getGrade));

        return bookGrades;
    }

    @Override
    public List<EmailDto> getEmails(GenreDto genreDto, Integer criteria) {
        Genre genre = genreRepository.findById(genreDto.getId()).orElseThrow(NoGenreException::new);
        Map<String, Integer> rating = new HashMap<>();
        for (BooksGenres booksGenres : genre.getBooksGenres()) {
            Book book = booksGenres.getBook();
            for (Purchase purchase : book.getPurchases()) {
                if (rating.containsKey(purchase.getPurchaser().getEmail())) {
                    rating.put(purchase.getPurchaser().getEmail(), rating.get(purchase.getPurchaser().getEmail()) + purchase.getQuantity());
                } else {
                    rating.put(purchase.getPurchaser().getEmail(), purchase.getQuantity());
                }
            }
        }

        List<EmailDto> emails = new ArrayList<>();

        for (var entry : rating.entrySet()) {
            if (entry.getValue() >= criteria) {
                emails.add(new EmailDto(entry.getKey(), purchaserRepository
                        .findByEmail(entry.getKey()).orElseThrow(NoPurchaserException::new).getName(),
                        entry.getValue()));
            }
        }
        return emails;
    }
}
