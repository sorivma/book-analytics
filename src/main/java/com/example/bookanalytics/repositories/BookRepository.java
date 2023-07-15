package com.example.bookanalytics.repositories;

import com.example.bookanalytics.models.Book;
import com.example.bookanalytics.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findAllByPublisher(String publisher);
    @Query("select b from Book b join b.genres g where g = :genres")
    List<Book> findAllByGenre(Genre genres);
}
