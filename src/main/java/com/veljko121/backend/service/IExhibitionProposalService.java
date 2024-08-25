package com.veljko121.backend.service;

import com.veljko121.backend.core.service.ICRUDService;
import com.veljko121.backend.dto.ExhibitionProposalDTO;
import com.veljko121.backend.model.Exhibition;
import com.veljko121.backend.model.ExhibitionProposal;

import java.util.List;

public interface IExhibitionProposalService extends ICRUDService<ExhibitionProposal, Integer> {
    public ExhibitionProposal createProposal(ExhibitionProposalDTO proposalDTO);
    List<ExhibitionProposal> findByOrganizerId(Integer organizerId);
}

