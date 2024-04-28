package com.veljko121.backend.dto.tours;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TourCreateDTO {

    private String name;

    private String description;

    //private List<Integer> roomIds = new ArrayList<>();

    private String duration;

    private LocalDateTime occurrenceDateTime;

    private String adultTicketPrice;

    private String minorTicketPrice;

    private Integer guideId;

    private String capacity;

    private String picturePath;

}
