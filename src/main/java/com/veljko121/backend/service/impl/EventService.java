package com.veljko121.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veljko121.backend.core.service.impl.CRUDService;
import com.veljko121.backend.model.Event;
import com.veljko121.backend.repository.EventRepository;
import com.veljko121.backend.service.IEventService;

@Service
public class EventService extends CRUDService<Event, Integer> implements IEventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository repository) {
        super(repository);
        eventRepository = repository;
    }
    
}
