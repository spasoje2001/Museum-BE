package com.veljko121.backend.service;

import com.veljko121.backend.core.service.ICRUDService;
import com.veljko121.backend.dto.CreateExhibitionDTO;
import com.veljko121.backend.dto.ExhibitionProposalDTO;
import com.veljko121.backend.dto.ExhibitionSearchRequestDTO;
import com.veljko121.backend.model.Exhibition;
import com.veljko121.backend.model.ExhibitionProposal;

import java.util.List;

public interface IExhibitionService extends ICRUDService<Exhibition, Integer> {
    List<Exhibition> findAll();
    List<Exhibition> getExhibitionsForPreviousMonth();
    List<Exhibition> getExhibitionsForPreviousYear(Integer curatorId);
    List<Exhibition> findByOrganizerId(Integer organizerId);

    List<Exhibition> findByCuratorId(Integer curatorId);

    Exhibition createExhibition(CreateExhibitionDTO createExhibitionDTO);

    Exhibition updateExhibition(Integer id, CreateExhibitionDTO exhibitionDTO);
    List<Exhibition> searchExhibitions(ExhibitionSearchRequestDTO searchRequest);


}
