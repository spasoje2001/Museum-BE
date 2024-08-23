package com.veljko121.backend.service.impl;

import com.veljko121.backend.core.enums.ExhibitionStatus;
import com.veljko121.backend.core.service.impl.CRUDService;
import com.veljko121.backend.dto.ExhibitionProposalDTO;
import com.veljko121.backend.model.*;
import com.veljko121.backend.repository.ExhibitionProposalRepository;
import com.veljko121.backend.repository.ExhibitionRepository;
import com.veljko121.backend.service.*;
import com.veljko121.backend.util.DateUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

@Service
public class ExhibitionProposalService extends CRUDService<ExhibitionProposal, Integer> implements IExhibitionProposalService {

    private final ExhibitionProposalRepository exhibitionProposalRepository;

    @Autowired
    private IExhibitionPriceListService exhibitionPriceListService;

    @Autowired
    private IOrganizerService organizerService;

    @Autowired
    private IRoomService roomService;

    @Autowired
    private IRoomReservationService roomReservationService;


    public ExhibitionProposalService(ExhibitionProposalRepository repository) {
        super(repository);
        exhibitionProposalRepository = repository;
    }

    @Transactional
    public ExhibitionProposal createProposal(ExhibitionProposalDTO proposalDTO) {
        ExhibitionProposal proposal = new ExhibitionProposal();

        LocalDate startDate = DateUtil.stringToDate(proposalDTO.getStartDate());
        LocalDate endDate = DateUtil.stringToDate(proposalDTO.getEndDate());

        proposal.setStartDate(startDate);
        proposal.setEndDate(endDate);

        ExhibitionPriceList priceList = new ExhibitionPriceList();
        priceList.setAdultTicketPrice(proposalDTO.getAdultPrice());
        priceList.setMinorTicketPrice(proposalDTO.getMinorPrice());
        proposal.setExhibitionPriceList(exhibitionPriceListService.save(priceList));

        Organizer organizer = organizerService.findById(proposalDTO.getOrganizerId());
        proposal.setOrganizer(organizer);

        RoomReservation roomReservation = new RoomReservation();
        roomReservation.setRoom(roomService.findById(proposalDTO.getRoomId()));
        roomReservation.setStartDate(startDate);
        roomReservation.setEndDate(endDate);
        roomReservation.setExhibitionProposal(proposal);
        proposal.setRoomReservation(roomReservationService.save(roomReservation));

        return exhibitionProposalRepository.save(proposal);
    }
}