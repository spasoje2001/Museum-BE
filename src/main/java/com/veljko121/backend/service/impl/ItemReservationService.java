package com.veljko121.backend.service.impl;

import com.veljko121.backend.core.service.impl.CRUDService;
import com.veljko121.backend.model.Exhibition;
import com.veljko121.backend.model.ItemReservation;
import com.veljko121.backend.repository.ExhibitionRepository;
import com.veljko121.backend.repository.ItemReservationRepository;
import com.veljko121.backend.service.IExhibitionService;
import com.veljko121.backend.service.IItemReservationService;
import org.springframework.stereotype.Service;

@Service
public class ItemReservationService extends CRUDService<ItemReservation, Integer> implements IItemReservationService {
    private final ItemReservationRepository itemReservationRepository;

    public ItemReservationService(ItemReservationRepository repository) {
        super(repository);
        itemReservationRepository = repository;
    }
}
