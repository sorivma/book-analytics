package com.example.bookanalytics;

import com.example.bookanalytics.dtos.FeedBackDto;
import com.example.bookanalytics.dtos.PurchaseDto;
import com.example.bookanalytics.models.Feedback;
import com.example.bookanalytics.models.Purchase;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
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

        TypeMap<Purchase, PurchaseDto> propertyMapper = modelMapper.createTypeMap(Purchase.class, PurchaseDto.class);
        propertyMapper.addMapping(
                Purchase::getBook, PurchaseDto::setBookDto
        );
        propertyMapper.addMapping(
                Purchase::getPurchaser, PurchaseDto::setPurchaserDto
        );

        return modelMapper;
    }
    public static void main(String[] args) {
        SpringApplication.run(BookAnalyticsApplication.class, args);
    }

}
