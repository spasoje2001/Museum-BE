package com.veljko121.backend.service.impl.events;

import org.springframework.stereotype.Service;

import com.veljko121.backend.core.service.impl.CRUDService;
import com.veljko121.backend.model.events.EventInvitation;
import com.veljko121.backend.repository.events.EventInvitationRepository;
import com.veljko121.backend.service.events.IEventInvitationService;

@Service
public class EventInvitationService extends CRUDService<EventInvitation, Integer> implements IEventInvitationService {
    
    public EventInvitationService(EventInvitationRepository repository) {
        super(repository);
    }

}
