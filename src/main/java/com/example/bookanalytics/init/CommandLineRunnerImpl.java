package com.example.bookanalytics.init;

import com.example.bookanalytics.dtos.BookDto;
import com.example.bookanalytics.dtos.GenreDto;
import com.example.bookanalytics.dtos.PurchaseDto;
import com.example.bookanalytics.dtos.PurchaserDto;
import com.example.bookanalytics.models.Genre;
import com.example.bookanalytics.services.BookService;
import com.example.bookanalytics.services.GenreService;
import com.example.bookanalytics.services.PurchaseService;
import com.example.bookanalytics.services.PurchaserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    @Autowired
    private GenreService genreService;
    @Autowired
    private BookService bookService;
    @Autowired
    private PurchaseService purchaseService;

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
        PurchaseDto purchaseDto = new PurchaseDto(5, bookDto2, purchaserDto);
        purchaseService.purchase(purchaseDto);

        purchaserDto.setId(1);
        PurchaseDto purchaseDto1 = new PurchaseDto(10, bookDto1, purchaserDto);
        purchaseService.purchase(purchaseDto1);

        PurchaseDto purchaseDto2 = new PurchaseDto(5, bookDto2, purchaserDto);
        PurchaseDto purchaseDto3 = new PurchaseDto(6, bookDto3, purchaserDto);
        purchaseService.purchase(purchaseDto2);
        purchaseService.purchase(purchaseDto3);

        purchaseService.delete(1);
        purchaseService.delete(2);
        purchaseService.delete(3);
        purchaseService.delete(4);
    }
}
