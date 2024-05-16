package com.veljko121.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veljko121.backend.core.enums.CleaningStatus;
import com.veljko121.backend.core.service.impl.CRUDService;
import com.veljko121.backend.model.Item;
import com.veljko121.backend.model.Room;
import com.veljko121.backend.repository.ItemRepository;
import com.veljko121.backend.repository.RoomRepository;
import com.veljko121.backend.service.IItemService;

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

    public List<Item> getAllItemsForCleaning() {
        List<Item> itemsForCleaning = new ArrayList<>();
        List<Item> allItems = itemRepository.findAll();
        for(Item item : allItems){
            if(item.getCleaning() != null){
                if(item.getCleaning().getStatus() != CleaningStatus.CLEANSED){
                    itemsForCleaning.add(item);
                }
            }else{
                itemsForCleaning.add(item);
            }
        }
        return itemsForCleaning;
    }

    @Override
    public Item findById(Integer itemId) {
        return itemRepository.findById(itemId).orElseThrow();
    }


    public List<Item> getAllItemsForDisplay() {
        List<Item> itemsForDisplaying = new ArrayList<>();
        List<Item> allItems = itemRepository.findAll();
        for(Item item : allItems){
            if(item.getCleaning() != null){
                if(item.getCleaning().getStatus() == CleaningStatus.CLEANSED && item.getRoom() == null){
                    itemsForDisplaying.add(item);
                }
            }else{
                itemsForDisplaying.add(item);
            }
        }
        return itemsForDisplaying;
    }

    public Item update(Item item) {
        return itemRepository.save(item);
    }


    public Item putItemIntoRoom(Integer itemId,Integer roomId){
        Room room = roomRepository.findById(roomId).orElseThrow();
        Item item = itemRepository.findById(itemId).orElseThrow();
        item.setRoom(room);
        return itemRepository.save(item);
    }

}
