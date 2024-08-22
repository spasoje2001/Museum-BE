package com.veljko121.backend.service;

import com.veljko121.backend.dto.ReviewDTO;
import com.veljko121.backend.model.Review;

import java.util.List;

public interface IReviewService {
    public List<Review> getReviewsByExhibitionId(Integer exhibitionId);
    public Review createReview(ReviewDTO reviewDTO);

}
