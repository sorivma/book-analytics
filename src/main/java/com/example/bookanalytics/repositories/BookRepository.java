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
    @Query("select b from Book b join b.booksGenres bg join bg.genre g where g = :genres")
    List<Book> findAllByGenre(Genre genres);

    @Query("select distinct b.publisher from Book b")
    List<String> findAllPublishers();

    @Query("select sum(p.quantity) from Book b join b.purchases p where b.publisher = :publisher")
    Integer findTotalQuantity(String publisher);

    @Query("select b.name from Book b join b.purchases p where b.publisher = :publisher " +
            "group by b.name order by sum(p.quantity) desc limit 1")
    String findBestSeller(String publisher);
}
