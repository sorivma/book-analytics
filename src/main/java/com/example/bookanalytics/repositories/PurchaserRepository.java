package com.example.bookanalytics.repositories;

import com.example.bookanalytics.models.Purchase;
import com.example.bookanalytics.models.Purchaser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PurchaserRepository extends JpaRepository<Purchaser, Integer> {
    void deleteByEmail(String email);
    Optional<Purchaser> findByEmail(String email);
}
