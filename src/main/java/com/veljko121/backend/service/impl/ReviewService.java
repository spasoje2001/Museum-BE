package com.veljko121.backend.service.impl;

import com.veljko121.backend.core.service.impl.CRUDService;
import com.veljko121.backend.dto.ReviewDTO;
import com.veljko121.backend.model.Exhibition;
import com.veljko121.backend.model.Guest;
import com.veljko121.backend.model.Review;
import com.veljko121.backend.repository.ReviewRepository;
import com.veljko121.backend.repository.TicketRepository;
import com.veljko121.backend.service.IExhibitionService;
import com.veljko121.backend.service.IGuestService;
import com.veljko121.backend.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService extends CRUDService<Review, Integer> implements IReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    private IGuestService guestService;

    @Autowired
    private IExhibitionService exhibitionService;


    public ReviewService(ReviewRepository repository) {
        super(repository);
        reviewRepository = repository;
    }

    public List<Review> getReviewsByExhibitionId(Integer exhibitionId) {
        return reviewRepository.findByExhibitionIdOrderByReviewDateDesc(exhibitionId);
    }


    @Override
    public Review createReview(ReviewDTO reviewDTO) {
        Exhibition exhibition = exhibitionService.findById(reviewDTO.getExhibitionId());
        Guest guest = guestService.findById(reviewDTO.getGuestId());

        if (reviewRepository.existsByGuestIdAndExhibitionId(reviewDTO.getGuestId(), reviewDTO.getExhibitionId())) {
            throw new IllegalArgumentException("Guest has already reviewed this exhibition");
        }

        Review review = new Review(guest, exhibition, reviewDTO.getRating());

        return reviewRepository.save(review);
    }

    @Override
    public boolean hasUserReviewedExhibition(Integer exhibitionId, Integer userId) {
        return reviewRepository.existsByGuestIdAndExhibitionId(userId, exhibitionId);
    }

}
