package com.veljko121.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class BookTicketsDTO {
    private Integer guestId;
    private Integer exhibitionId;
    private int numberOfAdults;
    private int numberOfMinors;
    private BigDecimal totalPrice;
}
