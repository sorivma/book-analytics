package com.example.bookanalytics.init;

import com.example.bookanalytics.dtos.*;
import com.example.bookanalytics.repositories.BookRepository;
import com.example.bookanalytics.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final GenreService genreService;
    private final BookService bookService;
    private final PurchaseService purchaseService;
    private final FeedBackService feedBackService;
    private final AnalyticsService analyticsService;
    private final BookRepository bookRepository;

    public CommandLineRunnerImpl(GenreService genreService, BookService bookService, PurchaseService purchaseService, FeedBackService feedBackService, AnalyticsService analyticsService, BookRepository bookRepository) {
        this.genreService = genreService;
        this.bookService = bookService;
        this.purchaseService = purchaseService;
        this.feedBackService = feedBackService;
        this.analyticsService = analyticsService;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();
    }

    private void seedData(){
        GenreDto genreDto1 = new GenreDto(0, "Отечественная классика");
        GenreDto genreDto2 = new GenreDto(0, "Фэнтези");
        GenreDto genreDto3 = new GenreDto(0, "Роман");
        GenreDto genreDto4 = new GenreDto(0, "Исторические хроники");

        genreService.addGenre(genreDto1);
        genreService.addGenre(genreDto2);
        genreService.addGenre(genreDto3);
        genreService.addGenre(genreDto4);

        System.out.println(genreService.findAll());
        System.out.println(genreService.findById(4));

        genreDto1.setId(1);
        genreDto2.setId(2);
        genreDto3.setId(3);
        genreDto4.setId(4);

        BookDto bookDto1 = new BookDto(0, "Преступление и наказание", "Весенние грозы", "Ф.М. Достоевский", new HashSet<>(Arrays.asList(genreDto1, genreDto3)));
        BookDto bookDto2 = new BookDto(0, "Война и мир", "Весенние грозы", "Л.Н. Толстой", new HashSet<>(Arrays.asList(genreDto1, genreDto3, genreDto4)));
        BookDto bookDto3 = new BookDto(0, "Мастер и маргарита", "Таинственные тайны", "М.А Булгаков",new HashSet<>(Arrays.asList(genreDto1, genreDto2, genreDto3)));

        bookService.addBook(bookDto1);
        bookService.addBook(bookDto2);
        bookService.addBook(bookDto3);

        bookService.findBook(1);
        bookService.findPublisherBooks("Весенние грозы");
        System.out.println("Книги по жанрам: " + bookService.findBooks(genreDto4));

        bookDto1.setId(1);
        bookDto2.setId(2);
        bookDto3.setId(3);

        PurchaserDto purchaserDto = new PurchaserDto(0,"Вася", "vasya@gmail.com");
        PurchaserDto purchaserDto1 = new PurchaserDto(0, "Ваня", "vanyok@mail.ru");
        PurchaseDto purchaseDto = new PurchaseDto(5, bookDto2, purchaserDto);
        purchaseService.purchase(purchaseDto);

        purchaserDto.setId(1);
        PurchaseDto purchaseDto1 = new PurchaseDto(10, bookDto1, purchaserDto);
        purchaseService.purchase(purchaseDto1);

        PurchaseDto purchaseDto2 = new PurchaseDto(6, bookDto2, purchaserDto);
        PurchaseDto purchaseDto3 = new PurchaseDto(6, bookDto3, purchaserDto);
        PurchaseDto purchaseDto4 = new PurchaseDto(3, bookDto2, purchaserDto);
        purchaseService.purchase(purchaseDto2);
        purchaseService.purchase(purchaseDto3);
        purchaseService.purchase(purchaseDto4);

        PurchaseDto purchaseDto5 = new PurchaseDto(6, bookDto2, purchaserDto1);
        PurchaseDto purchaseDto6 = new PurchaseDto(6, bookDto3, purchaserDto1);
        PurchaseDto purchaseDto7 = new PurchaseDto(3, bookDto2, purchaserDto1);
        purchaseService.purchase(purchaseDto5);
        purchaserDto1.setId(2);
        purchaseService.purchase(purchaseDto6);
        purchaseService.purchase(purchaseDto7);

        feedBackService.leaveFeedBack(
                new FeedBackDto(0, 1, 1, 2, 3, 4, 5,
                        "В целом все норм"));
        feedBackService.leaveFeedBack(
                new FeedBackDto(0, 3, 1, 1, 2, 3, 4,
                        "Не люблю классику"));
        feedBackService.leaveFeedBack(
                new FeedBackDto(0, 5, 4, 4, 4, 4, 4,
                        "Среднячок"));

        System.out.println(analyticsService.analyzePurchaser(purchaserDto));

        System.out.println(bookRepository.findTotalQuantity("Таинственные тайны"));

        System.out.println(analyticsService.analyzePublishers());

        System.out.println(bookRepository.findBestSeller("Весенние грозы"));

        System.out.println(analyticsService.currentRanking());

        System.out.println(analyticsService.getEmails(genreDto3, 30));
    }
}
