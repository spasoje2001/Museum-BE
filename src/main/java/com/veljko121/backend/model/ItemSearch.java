package com.veljko121.backend.model;

import com.veljko121.backend.core.enums.ItemCategory;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemSearch {
    private String name;
    private String description;
    private String authorsName;
    private String period;
    private ItemCategory category;
}
