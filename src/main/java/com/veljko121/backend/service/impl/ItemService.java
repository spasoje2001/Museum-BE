package com.veljko121.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veljko121.backend.core.service.impl.CRUDService;
import com.veljko121.backend.model.Item;
import com.veljko121.backend.model.Room;
import com.veljko121.backend.repository.ItemRepository;
import com.veljko121.backend.repository.RoomRepository;
import com.veljko121.backend.service.IItemService;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService extends CRUDService<Item, Integer> implements IItemService{
    
    private final ItemRepository itemRepository;
    private final RoomRepository roomRepository;

    @Autowired
    public ItemService(ItemRepository repository, ItemRepository itemRepository, RoomRepository roomRepository) {
        super(repository);
        this.itemRepository = itemRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public Item findById(Integer itemId) {
        return itemRepository.findById(itemId).orElseThrow();
    }


    public Item update(Item item) {
        return itemRepository.save(item);
    }


    public List<Item> findByName(String name) {
        return itemRepository.findByName(name);
    }


}
