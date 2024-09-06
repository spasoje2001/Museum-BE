package com.veljko121.backend.dto;

import lombok.Data;

@Data
public class ReviewDTO {
    private Integer guestId;
    private Integer exhibitionId;
    private int rating;
}
