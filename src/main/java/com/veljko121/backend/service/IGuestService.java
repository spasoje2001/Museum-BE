package com.veljko121.backend.service;

import com.veljko121.backend.core.enums.ExhibitionTheme;
import com.veljko121.backend.core.service.ICRUDService;
import com.veljko121.backend.model.Exhibition;
import com.veljko121.backend.model.Guest;

import java.util.List;

public interface IGuestService extends ICRUDService<Guest, Integer> {

    Guest update(Guest updated);

    Guest findByUsername(String username);

    List<Guest> findUsersWithTicketsForExhibition(Exhibition exhibition);

    List<Guest> findUsersInterestedInTheme(ExhibitionTheme theme);

    List<Guest> findUsersWhoReviewedExhibition(Exhibition exhibition);

    List<Guest> findUsersWithoutTicketsForExhibition(Exhibition exhibition);


}
