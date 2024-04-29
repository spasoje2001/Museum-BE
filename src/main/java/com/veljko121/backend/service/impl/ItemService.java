package com.veljko121.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veljko121.backend.core.enums.CleaningStatus;
import com.veljko121.backend.core.service.impl.CRUDService;
import com.veljko121.backend.model.Curator;
import com.veljko121.backend.model.Item;
import com.veljko121.backend.repository.ItemRepository;
import com.veljko121.backend.service.IItemService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService extends CRUDService<Item, Integer> implements IItemService{
    
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository repository, ItemRepository itemRepository) {
        super(repository);
        this.itemRepository = itemRepository;
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

}
