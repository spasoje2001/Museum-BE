package com.veljko121.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.veljko121.backend.model.Item;

public interface ItemRepository  extends JpaRepository<Item, Integer>{
    
}
