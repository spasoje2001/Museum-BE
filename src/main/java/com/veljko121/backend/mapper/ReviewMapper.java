package com.veljko121.backend.mapper;

import com.veljko121.backend.dto.ReviewResponseDTO;
import com.veljko121.backend.dto.TicketResponseDTO;
import com.veljko121.backend.model.Review;
import com.veljko121.backend.model.Ticket;
import com.veljko121.backend.util.DateUtil;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ReviewMapper {
    public ReviewResponseDTO mapToDTO(Review review) {
        ReviewResponseDTO dto = new ReviewResponseDTO();
        dto.setId(review.getId());
        dto.setRating(review.getRating());
        dto.setReviewDate(DateUtil.dateToString(review.getReviewDate()));

        dto.setExhibitionId(review.getExhibition().getId());
        dto.setExhibitionName(review.getExhibition().getName());

        dto.setGuestId(review.getGuest().getId());
        dto.setGuestPicture(review.getGuest().getPicture());
        dto.setGuestFirstName(review.getGuest().getFirstName());
        dto.setGuestLastName(review.getGuest().getLastName());

        return dto;
    }
}
