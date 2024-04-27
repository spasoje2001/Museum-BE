package com.veljko121.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veljko121.backend.core.exception.RoomNotAvailableException;
import com.veljko121.backend.core.service.impl.CRUDService;
import com.veljko121.backend.model.Event;
import com.veljko121.backend.repository.EventRepository;
import com.veljko121.backend.repository.RoomRepository;
import com.veljko121.backend.service.IEventService;
import com.veljko121.backend.service.IRoomReservationService;

@Service
public class EventService extends CRUDService<Event, Integer> implements IEventService {

    private final RoomRepository roomRepository;
    private final IRoomReservationService roomReservationService;

    @Autowired
    public EventService(EventRepository repository, RoomRepository roomRepository, IRoomReservationService roomReservationService) {
        super(repository);
        this.roomRepository = roomRepository;
        this.roomReservationService = roomReservationService;
    }

    @Override
    public Event save(Event entity) throws RoomNotAvailableException {
        var room = roomRepository.findById(entity.getRoomReservation().getRoom().getId()).orElseThrow();
        var roomReservation = entity.getRoomReservation();
        if (!roomReservationService.isRoomAvailable(room, entity.getStartDateTime(), entity.getDurationMinutes())) {
            throw new RoomNotAvailableException(roomReservation);
        }

        roomReservation.setDurationMinutes(entity.getDurationMinutes());
        roomReservation.setStartDateTime(entity.getStartDateTime());
        roomReservation = roomReservationService.save(roomReservation);

        entity.setRoomReservation(roomReservation);

        return super.save(entity);
    }
    
}
