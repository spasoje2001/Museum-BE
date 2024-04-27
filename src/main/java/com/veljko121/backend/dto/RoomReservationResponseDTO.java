package com.veljko121.backend.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class RoomReservationResponseDTO {

    private Integer id;
    private LocalDateTime startDateTime;
    private Integer durationMinutes;
    private RoomResponseDTO room;

    public LocalDateTime getEndDateTime() {
        return startDateTime.plusMinutes(durationMinutes);
    }
    
}
