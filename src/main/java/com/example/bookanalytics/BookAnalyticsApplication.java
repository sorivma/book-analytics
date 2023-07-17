package com.example.bookanalytics;

import com.example.bookanalytics.dtos.GenreDto;
import com.example.bookanalytics.dtos.PurchaseDto;
import com.example.bookanalytics.models.BooksGenres;
import com.example.bookanalytics.models.Purchase;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.config.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookAnalyticsApplication {
    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

        TypeMap<Purchase, PurchaseDto> purchasePropertyMapper = modelMapper.createTypeMap(Purchase.class,
                PurchaseDto.class);
        purchasePropertyMapper.addMapping(
                Purchase::getBook, PurchaseDto::setBookDto
        );
        purchasePropertyMapper.addMapping(
                Purchase::getPurchaser, PurchaseDto::setPurchaserDto
        );

        TypeMap<BooksGenres, GenreDto> genrePropertyMapper = modelMapper.createTypeMap(BooksGenres.class,
                GenreDto.class);
        genrePropertyMapper.addMapping(booksGenres -> booksGenres.getGenre().getName(), GenreDto::setName);
        genrePropertyMapper.addMapping(booksGenres -> booksGenres.getGenre().getId(), GenreDto::setId);

        return modelMapper;
    }
    public static void main(String[] args) {
        SpringApplication.run(BookAnalyticsApplication.class, args);
    }

}
