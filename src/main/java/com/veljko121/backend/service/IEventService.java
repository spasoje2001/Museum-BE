package com.veljko121.backend.service;

import java.util.Collection;

import com.veljko121.backend.core.service.ICRUDService;
import com.veljko121.backend.model.Event;

public interface IEventService extends ICRUDService<Event, Integer> {

    void publish(Integer id);

    Collection<Event> findPublished();
    
}
