package com.veljko121.backend.dto.tours;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TourPricelistResponseDTO {

    private Integer id;

    private String name;

    private String description;

    private String adultTicketPrice;

    private String minorTicketPrice;

    private LocalDate startDate;

    private LocalDate expirationDate;

}
