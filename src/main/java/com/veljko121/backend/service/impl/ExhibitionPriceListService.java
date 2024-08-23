package com.veljko121.backend.service.impl;

import com.veljko121.backend.core.service.impl.CRUDService;
import com.veljko121.backend.model.ExhibitionPriceList;
import com.veljko121.backend.model.ExhibitionProposal;
import com.veljko121.backend.repository.ExhibitionPriceListRepository;
import com.veljko121.backend.repository.ExhibitionProposalRepository;
import com.veljko121.backend.service.IExhibitionPriceListService;
import com.veljko121.backend.service.IExhibitionProposalService;
import org.springframework.stereotype.Service;

@Service
public class ExhibitionPriceListService extends CRUDService<ExhibitionPriceList, Integer> implements IExhibitionPriceListService {
    private final ExhibitionPriceListRepository exhibitionPriceListRepository;

    public ExhibitionPriceListService(ExhibitionPriceListRepository repository) {
        super(repository);
        exhibitionPriceListRepository = repository;
    }
}
