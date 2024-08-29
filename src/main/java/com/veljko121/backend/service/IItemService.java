package com.veljko121.backend.service;

import java.time.LocalDate;
import java.util.List;

import com.veljko121.backend.core.service.ICRUDService;
import com.veljko121.backend.model.Item;
import com.veljko121.backend.model.Room;

public interface IItemService extends ICRUDService<Item, Integer>{

    List<Item> findAll();

    List<Item> findAvailableItems(LocalDate startDate, LocalDate endDate);

    List<Item> findAvailableItemsForUpdate(LocalDate startDate, LocalDate endDate, Integer exhibitionId);

    Item update(Item item);

    List<Item> findByName(String name);


}
