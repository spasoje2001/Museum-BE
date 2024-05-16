package com.veljko121.backend.service;

import java.util.List;

import com.veljko121.backend.core.service.ICRUDService;
import com.veljko121.backend.model.Item;

public interface IItemService extends ICRUDService<Item, Integer>{

    List<Item> findAll();
    List<Item> getAllItemsForCleaning();
    public List<Item> getAllItemsForDisplay();
    public Item update(Item item);
    public Item putItemIntoRoom(Integer itemId,Integer roomId);
}
