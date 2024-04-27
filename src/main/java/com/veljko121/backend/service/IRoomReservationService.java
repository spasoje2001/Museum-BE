package com.veljko121.backend.service;

import java.time.LocalDateTime;

import com.veljko121.backend.core.service.ICRUDService;
import com.veljko121.backend.model.Room;
import com.veljko121.backend.model.RoomReservation;

public interface IRoomReservationService extends ICRUDService<RoomReservation, Integer> {

    Boolean isRoomAvailable(Room room, LocalDateTime startDateTime, Integer durationMinutes);

}
