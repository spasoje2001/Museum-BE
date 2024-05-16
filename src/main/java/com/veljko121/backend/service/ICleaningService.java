package com.veljko121.backend.service;

import java.util.List;

import com.veljko121.backend.core.service.ICRUDService;
import com.veljko121.backend.model.Cleaning;

public interface ICleaningService extends ICRUDService<Cleaning, Integer> {

    public void addCleaningToItem(Integer itemId, Cleaning cleaning);
    public Cleaning save(Integer itemId, Cleaning cleaning ,Integer restaurateurId);
    public Cleaning declineCleaning(Integer cleaningId, Integer curatorId);
    public Cleaning acceptCleaning(Integer cleaningId, Integer curatorId);
    public List<Cleaning> getAllNewCleanings();
    public Cleaning putItemToCleaning(Integer cleaningId);
    public Cleaning finishleaning(Integer cleaningId);
}
