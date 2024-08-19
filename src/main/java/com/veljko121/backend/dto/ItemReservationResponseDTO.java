package com.veljko121.backend.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ItemReservationResponseDTO {
    private Integer id;
    private String startDate;
    private String endDate;
    private ItemResponseDTO item;
}
