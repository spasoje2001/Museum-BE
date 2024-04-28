package com.veljko121.backend.service;

import com.veljko121.backend.core.service.ICRUDService;
import com.veljko121.backend.model.PersonalTourRequest;

import java.util.List;

public interface IPersonalTourRequestService extends ICRUDService<PersonalTourRequest, Integer> {

    PersonalTourRequest update(PersonalTourRequest request);

    List<PersonalTourRequest> findByGuestId(Integer guestId);

    List<PersonalTourRequest> findAll();

    List<PersonalTourRequest> findInProgress();
}
