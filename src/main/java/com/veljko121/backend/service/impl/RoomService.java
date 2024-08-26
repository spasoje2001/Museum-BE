package com.veljko121.backend.service.impl;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.veljko121.backend.model.RoomReservation;
import com.veljko121.backend.service.IRoomReservationService;
import com.veljko121.backend.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veljko121.backend.core.service.impl.CRUDService;
import com.veljko121.backend.model.Room;
import com.veljko121.backend.repository.RoomRepository;
import com.veljko121.backend.service.IRoomService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoomService extends CRUDService<Room, Integer> implements IRoomService {

    private final RoomRepository roomRepository;

    @Autowired
    private IRoomReservationService roomReservationService;

    public RoomService(RoomRepository repository) {
        super(repository);
        this.roomRepository = repository;
    }

    
    public List<Room> findAll() {
        return roomRepository.findAll();
    }


    @Transactional(readOnly = true)
    public List<Room> findAvailableRooms(LocalDate startDate, LocalDate endDate) {
        return roomRepository.findAvailableRooms(startDate, endDate);
    }

    @Transactional(readOnly = true)
    public List<Room> findAvailableRoomsForUpdate(LocalDate startDate, LocalDate endDate, Integer proposalId) {
        return roomRepository.findAvailableRoomsForUpdate(startDate, endDate, proposalId);
    }
    
}
