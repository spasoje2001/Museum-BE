package com.veljko121.backend.dto;

import com.veljko121.backend.core.enums.ItemCategory;
import com.veljko121.backend.core.enums.ItemStatus;
import com.veljko121.backend.model.Room;
import lombok.Data;

@Data
public class ItemDTO {

    private String name;
    private String description;
    private String authorsName;
    private String yearOfCreation;
    private String period;
    private ItemCategory category;
    private String picture;
    private Room room;
    private ItemStatus status;
    
}
