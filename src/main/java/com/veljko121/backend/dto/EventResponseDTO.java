package com.veljko121.backend.dto;

import java.time.LocalDateTime;
import java.util.Collection;

import lombok.Data;

@Data
public class EventResponseDTO {

    private Integer id;
    private String name;
    private String description;
    private LocalDateTime startDateTime;
    private Integer durationMinutes;
    private Integer ticketsNumber;
    private Integer price;
    private OrganizerResponseDTO organizer;
    private LocalDateTime createdDateTime;
    private RoomReservationResponseDTO roomReservation;
    private Collection<EventPictureResponseDTO> pictures;
    
}
