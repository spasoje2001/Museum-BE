package com.veljko121.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ReviewResponseDTO {
    private Integer id;

    private Integer guestId;
    private String guestPicture;
    private String guestFirstName;
    private String guestLastName;

    private Integer exhibitionId;
    private String exhibitionName;

    private Integer rating;
    private String comment;
    private String reviewDate;
}
