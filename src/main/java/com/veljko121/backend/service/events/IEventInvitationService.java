package com.veljko121.backend.service.events;

import java.util.Collection;

import com.veljko121.backend.core.service.ICRUDService;
import com.veljko121.backend.model.events.EventInvitation;

public interface IEventInvitationService extends ICRUDService<EventInvitation, Integer> {

    void inviteCurators(Integer eventId, Collection<Integer> curatorIds);
    
    void acceptInvitation(Integer id);

    void declineInvitation(Integer id, String explanation);
    
}
