package com.veljko121.backend.repository;

import com.veljko121.backend.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByExhibitionIdOrderByReviewDateDesc(Integer exhibitionId);

    boolean existsByGuestIdAndExhibitionId(Integer guestId, Integer exhibitionId);
}
