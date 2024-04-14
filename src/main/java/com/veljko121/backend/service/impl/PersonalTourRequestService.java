package com.veljko121.backend.service.impl;

import com.veljko121.backend.core.service.impl.CRUDService;
import com.veljko121.backend.model.PersonalTourRequest;
import com.veljko121.backend.repository.PersonalTourRequestRepository;
import com.veljko121.backend.service.IPersonalTourRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalTourRequestService extends CRUDService<PersonalTourRequest, Integer> implements IPersonalTourRequestService{

    @Autowired
    private final PersonalTourRequestRepository personalTourRequestRepository;

    public PersonalTourRequestService(JpaRepository<PersonalTourRequest, Integer> repository,
                                      PersonalTourRequestRepository personalTourRequestRepository) {
        super(repository);
        this.personalTourRequestRepository = personalTourRequestRepository;
    }

    @Override
    public PersonalTourRequest save(PersonalTourRequest request) {
        return personalTourRequestRepository.save(request);
    }

    @Override
    public PersonalTourRequest update(PersonalTourRequest request) {
        return personalTourRequestRepository.save(request);
    }

    public List<PersonalTourRequest> findByGuestId(Integer guestId){
        return personalTourRequestRepository.findByGuestId(guestId);
    }

    @Override
    public List<PersonalTourRequest> findAll(){
        return personalTourRequestRepository.findAll();
    }

}
