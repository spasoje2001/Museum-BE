package com.veljko121.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veljko121.backend.core.service.impl.CRUDService;
import com.veljko121.backend.model.Room;
import com.veljko121.backend.repository.RoomRepository;
import com.veljko121.backend.service.IRoomService;

@Service
public class RoomService extends CRUDService<Room, Integer> implements IRoomService {

    private final RoomRepository roomRepository;
        
    @Autowired
    public RoomService(RoomRepository repository) {
        super(repository);
        roomRepository = repository;
    }

    
    public List<Room> findAll() {
        return roomRepository.findAll();
    }
    
}
