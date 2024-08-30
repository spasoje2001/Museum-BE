package com.veljko121.backend.service;

import com.veljko121.backend.core.service.ICRUDService;
import com.veljko121.backend.dto.ReviewDTO;
import com.veljko121.backend.model.Review;
import com.veljko121.backend.model.RoomReservation;

import java.util.List;

public interface IReviewService extends ICRUDService<Review, Integer> {
    public List<Review> getReviewsByExhibitionId(Integer exhibitionId);
    public Review createReview(ReviewDTO reviewDTO);

}
