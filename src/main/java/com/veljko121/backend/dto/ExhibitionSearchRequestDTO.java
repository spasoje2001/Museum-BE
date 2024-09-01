package com.veljko121.backend.dto;


import com.veljko121.backend.core.enums.ExhibitionStatus;
import com.veljko121.backend.core.enums.ExhibitionTheme;
import com.veljko121.backend.core.enums.ItemCategory;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ExhibitionSearchRequestDTO {
    private String name;
    private String shortDescription;
    private String longDescription;
    private ExhibitionTheme theme;
    private ExhibitionStatus status;
    private String startDate;
    private String endDate;
    private String organizer;
    private String curator;
    private String itemName;
    private String itemDescription;
    private String itemAuthorsName;
    private String itemPeriod;
    private ItemCategory itemCategory;
    private Integer minRating;
    private String comment;
    private String guest;
}
