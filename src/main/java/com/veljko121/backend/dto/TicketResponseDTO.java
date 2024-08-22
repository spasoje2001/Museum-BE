package com.veljko121.backend.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class TicketResponseDTO {
    private Integer id;
    private int numberOfAdults;
    private int numberOfMinors;
    private BigDecimal totalPrice;

    private Integer exhibitionId;
    private String exhibitionName;
    private String exhibitionStartDate;
    private String exhibitionEndDate;

    private Integer guestId;
    private String guestFirstName;
    private String guestLastName;
}
