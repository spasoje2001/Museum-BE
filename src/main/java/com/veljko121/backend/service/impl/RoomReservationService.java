package com.veljko121.backend.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veljko121.backend.core.service.impl.CRUDService;
import com.veljko121.backend.model.Room;
import com.veljko121.backend.model.RoomReservation;
import com.veljko121.backend.repository.RoomReservationRepository;
import com.veljko121.backend.service.IRoomReservationService;

@Service
public class RoomReservationService extends CRUDService<RoomReservation, Integer> implements IRoomReservationService {

    private final RoomReservationRepository roomReservationRepository;
    
    @Autowired
    public RoomReservationService(RoomReservationRepository repository) {
        super(repository);
        this.roomReservationRepository = repository;
    }

    private Boolean overlaps(RoomReservation reservation, LocalDateTime startDateTime, Integer durationMinutes) {
        var reservationStartDateTime = reservation.getStartDateTime();
        var reservationEndDateTime = reservationStartDateTime.plusMinutes(reservation.getDurationMinutes());
        var endDateTime = startDateTime.plusMinutes(durationMinutes);

        if ((startDateTime.isAfter(reservationStartDateTime) || startDateTime.isEqual(reservationStartDateTime)) && startDateTime.isBefore(reservationEndDateTime) ||
            (endDateTime.isAfter(reservationStartDateTime)) && (endDateTime.isBefore(reservationEndDateTime) || endDateTime.isEqual(reservationEndDateTime))) {
            return true;
        }

        return false;
    }

    @Override
    public Boolean isRoomAvailable(Room room, LocalDateTime startDateTime, Integer durationMinutes) {
        for (var reservation : roomReservationRepository.findByRoom(room)) {
            if (overlaps(reservation, startDateTime, durationMinutes)) {
                return false;
            }
        }
        return true;
    }
    
}
