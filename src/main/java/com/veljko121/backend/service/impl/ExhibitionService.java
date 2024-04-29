package com.veljko121.backend.service.impl;

import com.veljko121.backend.core.service.impl.CRUDService;
import com.veljko121.backend.model.Event;
import com.veljko121.backend.model.Exhibition;
import com.veljko121.backend.model.Item;
import com.veljko121.backend.repository.EventRepository;
import com.veljko121.backend.repository.ExhibitionRepository;
import com.veljko121.backend.repository.RoomRepository;
import com.veljko121.backend.service.IEventService;
import com.veljko121.backend.service.IExhibitionService;
import com.veljko121.backend.service.IRoomReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExhibitionService extends CRUDService<Exhibition, Integer> implements IExhibitionService {
    private final ExhibitionRepository exhibitionRepository;

    @Autowired
    public ExhibitionService(ExhibitionRepository repository) {
        super(repository);
        exhibitionRepository = repository;
    }

    @Override
    public List<Exhibition> findAll() {
        return exhibitionRepository.findAll();
    }
}
