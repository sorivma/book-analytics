package com.example.bookanalytics.repositories;

import com.example.bookanalytics.models.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
    @Query("select avg(f.exteriorDesign + f.materialFeed + f.paperQuality + f.plotOfBook + f.qualityOfDelivery)/5 " +
            "from Feedback f join f.purchase p where p.book.id = :bookId")
    Optional<Double> getAvgRating(Integer bookId);
}
