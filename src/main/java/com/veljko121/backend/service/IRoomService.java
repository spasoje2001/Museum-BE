package com.veljko121.backend.service;

import java.util.List;

import com.veljko121.backend.core.service.ICRUDService;
import com.veljko121.backend.model.Room;

public interface IRoomService extends ICRUDService<Room, Integer> {
    
    public List<Room> findAll();
}
