package com.veljko121.backend.controller;

import com.veljko121.backend.dto.ReviewDTO;
import com.veljko121.backend.dto.ReviewResponseDTO;
import com.veljko121.backend.mapper.ReviewMapper;
import com.veljko121.backend.mapper.TicketMapper;
import com.veljko121.backend.model.Review;
import com.veljko121.backend.service.IReviewService;
import com.veljko121.backend.service.ITicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final IReviewService reviewService;
    private final ReviewMapper reviewMapper;

    @GetMapping("/exhibition/{exhibitionId}")
    public ResponseEntity<List<ReviewResponseDTO>> getReviewsByExhibitionId(@PathVariable Integer exhibitionId) {
        List<Review> reviews = reviewService.getReviewsByExhibitionId(exhibitionId);

        // Use the mapper to convert the list of Review entities to a list of ReviewResponseDTOs
        List<ReviewResponseDTO> reviewResponseDTOs = reviews.stream()
                .map(reviewMapper::mapToDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(reviewResponseDTOs);
    }

    @PostMapping
    public ResponseEntity<?> createReview(@RequestBody ReviewDTO reviewDTO) {
        try {
            Review createdReview = reviewService.createReview(reviewDTO);
            ReviewResponseDTO dto = reviewMapper.mapToDTO(createdReview);
            return ResponseEntity.ok(dto);
        } catch (IllegalArgumentException e) {
            // Vraća HTTP 400 sa porukom o grešci
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/exhibition/{exhibitionId}/has-reviewed")
    public ResponseEntity<Boolean> hasUserReviewedExhibition(@PathVariable Integer exhibitionId, @RequestParam Integer userId) {
        boolean hasReviewed = reviewService.hasUserReviewedExhibition(exhibitionId, userId);
        return ResponseEntity.ok(hasReviewed);
    }


}
