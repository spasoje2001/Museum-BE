package com.veljko121.backend.service;

import com.veljko121.backend.core.service.ICRUDService;
import com.veljko121.backend.model.Event;
import com.veljko121.backend.model.Exhibition;
import com.veljko121.backend.model.Item;

import java.util.List;

public interface IExhibitionService extends ICRUDService<Exhibition, Integer> {
    List<Exhibition> findAll();
}
