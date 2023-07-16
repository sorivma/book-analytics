package com.example.bookanalytics.repositories;

import com.example.bookanalytics.models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
    @Query("select p from Purchase p where p.purchaser.id = :purchaserId")
    List<Purchase> findByPurchaserId(@Param(value = "purchaserId") Integer purchaserId);
}
