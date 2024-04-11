package com.veljko121.backend.service.impl;

import com.veljko121.backend.core.service.impl.CRUDService;
import com.veljko121.backend.model.PersonalTour;
import com.veljko121.backend.repository.PersonalTourRepository;
import com.veljko121.backend.service.IPersonalTourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonalTourService extends CRUDService<PersonalTour, Integer> implements IPersonalTourService {

    @Autowired
    private final PersonalTourRepository personalTourRepository;

    public PersonalTourService(JpaRepository<PersonalTour, Integer> repository,
                                      PersonalTourRepository personalTourRepository) {
        super(repository);
        this.personalTourRepository = personalTourRepository;
    }

    @Override
    public PersonalTour save(PersonalTour tour) {
        return personalTourRepository.save(tour);
    }

}
