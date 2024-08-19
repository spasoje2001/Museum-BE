package com.veljko121.backend.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

import com.veljko121.backend.core.service.ICRUDService;
import com.veljko121.backend.model.Room;
import com.veljko121.backend.model.RoomReservation;

public interface IRoomReservationService extends ICRUDService<RoomReservation, Integer> {
    Collection<Room> findAvailableRoomsBetweenDates(LocalDate startDate, LocalDate endDate);

}
