package com.veljko121.backend.service;

import com.veljko121.backend.core.service.ICRUDService;
import com.veljko121.backend.dto.CreateExhibitionDTO;
import com.veljko121.backend.dto.ExhibitionProposalDTO;
import com.veljko121.backend.model.Exhibition;

import java.util.List;

public interface IExhibitionService extends ICRUDService<Exhibition, Integer> {
    List<Exhibition> findAll();
    List<Exhibition> getExhibitionsForPreviousMonth();
    List<Exhibition> getExhibitionsForPreviousYear(Integer curatorId);
    List<Exhibition> findByOrganizerId(Integer organizerId);

    List<Exhibition> findByCuratorId(Integer curatorId);

    public Exhibition createExhibition(CreateExhibitionDTO createExhibitionDTO);

}
