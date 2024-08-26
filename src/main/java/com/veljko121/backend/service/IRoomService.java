package com.veljko121.backend.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.veljko121.backend.core.service.ICRUDService;
import com.veljko121.backend.model.Room;

public interface IRoomService extends ICRUDService<Room, Integer> {
    
    public List<Room> findAll();

    public List<Room> findAvailableRooms(LocalDate startDate, LocalDate endDate);

    public List<Room> findAvailableRoomsForUpdate(LocalDate startDate, LocalDate endDate, Integer proposalId);
}
