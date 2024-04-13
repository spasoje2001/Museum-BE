package com.veljko121.backend.service;

import com.veljko121.backend.core.service.ICRUDService;
import com.veljko121.backend.model.Tour;

import java.util.List;

public interface ITourService extends ICRUDService<Tour, Integer> {

    List<Tour> findAll();

    List<Tour> findByOrganizerId(Integer organizerId);

}
