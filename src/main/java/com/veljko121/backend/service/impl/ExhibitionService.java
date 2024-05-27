package com.veljko121.backend.service.impl;

import com.veljko121.backend.core.enums.ExhibitionStatus;
import com.veljko121.backend.core.service.impl.CRUDService;
import com.veljko121.backend.dto.ExhibitionProposalDTO;
import com.veljko121.backend.model.Curator;
import com.veljko121.backend.model.Exhibition;
import com.veljko121.backend.model.RoomReservation;
import com.veljko121.backend.repository.ExhibitionRepository;
import com.veljko121.backend.service.*;
import com.veljko121.backend.util.DateUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class ExhibitionService extends CRUDService<Exhibition, Integer> implements IExhibitionService {
    private final ExhibitionRepository exhibitionRepository;
    @Autowired
    private ICuratorService curatorService;

    @Autowired
    private IOrganizerService organizerService;

    @Autowired
    private IRoomService roomService;

    @Autowired
    private IRoomReservationService roomReservationService;

    public ExhibitionService(ExhibitionRepository repository) {
        super(repository);
        exhibitionRepository = repository;
    }

    @Transactional
    public Exhibition proposeExhibition(ExhibitionProposalDTO proposalDTO) {
        Exhibition exhibition = new Exhibition();

        Date startDate;
        Date endDate = null;
        try {
            startDate = DateUtil.stringToDate(proposalDTO.getStartDate());
            endDate = DateUtil.stringToDate(proposalDTO.getEndDate());
        } catch (ParseException e) {
            throw new IllegalArgumentException("The provided date is not in the expected format (dd.MM.yyyy.).", e);
        }

        exhibition.setStartDate(startDate);
        exhibition.setEndDate(endDate);
        exhibition.setPrice(proposalDTO.getPrice());
        exhibition.setStatus(ExhibitionStatus.PROPOSED); // Postavljate status na PROPOSED
        exhibition.setOrganizer(organizerService.findById(proposalDTO.getOrganizerId()));
        exhibition.setCurator(curatorService.findById(proposalDTO.getCuratorId()));

        RoomReservation roomReservation = new RoomReservation();
        roomReservation.setRoom(roomService.findById(proposalDTO.getRoomId()));
        LocalTime startTime = LocalTime.of(9, 0); // 9 AM
        LocalTime endTime = LocalTime.of(21, 0); // 9 PM
        roomReservation.setStartDateTime(startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().atTime(startTime));
        roomReservation.setEndDateTime(endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().atTime(endTime));
        roomReservationService.save(roomReservation);

        exhibition.setRoomReservation(roomReservation);

        Exhibition savedExhibition = exhibitionRepository.save(exhibition);
        savedExhibition.setName("Exhibition Proposal: " + savedExhibition.getId());

        return exhibitionRepository.save(savedExhibition);
    }

    @Override
    public List<Exhibition> findAll() {
        return exhibitionRepository.findAll();
    }
}
