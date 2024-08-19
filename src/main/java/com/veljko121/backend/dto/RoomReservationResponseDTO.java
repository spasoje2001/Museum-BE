package com.veljko121.backend.dto;

import java.time.LocalDateTime;

import lombok.Data;
import org.springframework.cglib.core.Local;

@Data
public class RoomReservationResponseDTO {

    private Integer id;
    private String startDate;
    private String endDate;
    private RoomResponseDTO room;

}
