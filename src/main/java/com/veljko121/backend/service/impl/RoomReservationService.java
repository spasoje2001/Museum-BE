package com.veljko121.backend.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.veljko121.backend.core.service.impl.CRUDService;
import com.veljko121.backend.model.Room;
import com.veljko121.backend.model.RoomReservation;
import com.veljko121.backend.repository.RoomRepository;
import com.veljko121.backend.repository.RoomReservationRepository;
import com.veljko121.backend.service.IRoomReservationService;

@Service
public class RoomReservationService extends CRUDService<RoomReservation, Integer> implements IRoomReservationService {

    private final RoomReservationRepository roomReservationRepository;
    private final RoomRepository roomRepository;
    
    public RoomReservationService(RoomReservationRepository repository, RoomRepository roomRepository) {
        super(repository);
        this.roomReservationRepository = repository;
        this.roomRepository = roomRepository;
    }

    public Collection<Room> findAvailableRoomsBetweenDates(LocalDate startDate, LocalDate endDate) {
        // Find all rooms that have no reservations overlapping the given date range
        List<Room> allRooms = roomRepository.findAll();

        Set<Room> availableRooms = allRooms.stream()
                .filter(room -> roomReservationRepository.findByRoomAndDates(room, startDate, endDate).isEmpty())
                .collect(Collectors.toSet());

        return availableRooms;
    }
    
}
