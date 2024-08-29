package com.veljko121.backend.service.impl;

import com.veljko121.backend.core.enums.ExhibitionStatus;
import com.veljko121.backend.core.service.impl.CRUDService;
import com.veljko121.backend.dto.CreateExhibitionDTO;
import com.veljko121.backend.dto.ExhibitionProposalDTO;
import com.veljko121.backend.model.*;
import com.veljko121.backend.repository.ExhibitionRepository;
import com.veljko121.backend.service.*;
import com.veljko121.backend.util.DateUtil;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    private IItemService itemService;

    @Autowired
    private IItemReservationService itemReservationService;
    @Autowired
    private IExhibitionProposalService exhibitionProposalService;

    public ExhibitionService(ExhibitionRepository repository) {
        super(repository);
        exhibitionRepository = repository;
    }

    /*

    @Override
    public List<Exhibition> getExhibitionsForPreviousMonth() {
        YearMonth previousMonth = YearMonth.now().minusMonths(1);
        LocalDate startOfMonth = previousMonth.atDay(1);
        LocalDate endOfMonth = previousMonth.atEndOfMonth();

        Date startDateOfPreviousMonth = Date.from(startOfMonth.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date endDateOfPreviousMonth = Date.from(endOfMonth.atStartOfDay(ZoneId.systemDefault()).toInstant());

        List<Exhibition> allExhibitions = exhibitionRepository.findAll();

        return allExhibitions.stream()
                .filter(exhibition -> isValidStatus(exhibition.getStatus()) && isOverlapping(exhibition.getStartDate(), exhibition.getEndDate(), startDateOfPreviousMonth, endDateOfPreviousMonth))
                .collect(Collectors.toList());
    }

    @Override
    public List<Exhibition> getExhibitionsForPreviousYear(Integer curatorId) {
        LocalDate currentDate = LocalDate.now();

        // Calculate the start and end dates for the previous year
        LocalDate startDateOfPreviousYear = currentDate.minusYears(1);

        // Convert LocalDate to Date
        Date startDate = Date.from(startDateOfPreviousYear.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date endDate = Date.from(currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        List<Exhibition> allExhibitions = exhibitionRepository.findAll();

        // Get all exhibitions for the previous year
        return allExhibitions.stream()
                .filter(exhibition -> exhibition.getCurator().getId().equals(curatorId))
                .filter(exhibition -> isValidStatus(exhibition.getStatus()))
                .filter(exhibition -> isOverlapping(exhibition.getStartDate(), exhibition.getEndDate(), startDate, endDate))
                .collect(Collectors.toList());
    }

     */

    private boolean isOverlapping(Date exhibitionStartDate, Date exhibitionEndDate, Date startDateOfPreviousMonth, Date endDateOfPreviousMonth) {
        return (exhibitionStartDate.before(endDateOfPreviousMonth) || exhibitionStartDate.equals(endDateOfPreviousMonth)) &&
                (exhibitionEndDate.after(startDateOfPreviousMonth) || exhibitionEndDate.equals(startDateOfPreviousMonth));
    }


    private boolean isValidStatus(ExhibitionStatus status) {
        return status == ExhibitionStatus.READY_TO_OPEN ||
                status == ExhibitionStatus.OPENED ||
                status == ExhibitionStatus.CLOSED;
    }

    @Override
    public List<Exhibition> findAll() {
        return exhibitionRepository.findAll();
    }


    @Override
    public List<Exhibition> getExhibitionsForPreviousMonth() {
        return null;
    }

    @Override
    public List<Exhibition> getExhibitionsForPreviousYear(Integer curatorId) {
        return null;
    }

    @Override
    public List<Exhibition> findByOrganizerId(Integer organizerId) {
        return exhibitionRepository.findByExhibitionProposalOrganizerId(organizerId);
    }

    @Override
    public List<Exhibition> findByCuratorId(Integer curatorId) {
        return exhibitionRepository.findByCuratorId(curatorId);
    }

    @Override
    @Transactional
    public Exhibition createExhibition(CreateExhibitionDTO createExhibitionDTO) {
        // Load proposal
        ExhibitionProposal proposal = exhibitionProposalService.findById(createExhibitionDTO.getProposalId());

        // Create exhibition
        Exhibition exhibition = new Exhibition();
        exhibition.setName(createExhibitionDTO.getName());
        exhibition.setTheme(createExhibitionDTO.getTheme());
        exhibition.setShortDescription(createExhibitionDTO.getShortDescription());
        exhibition.setLongDescription(createExhibitionDTO.getLongDescription());
        exhibition.setPicture(createExhibitionDTO.getPicture());
        exhibition.setStatus(ExhibitionStatus.READY_TO_OPEN); // Default status
        exhibition.setExhibitionProposal(proposal);

        // Set curator
        Curator curator = curatorService.findById(createExhibitionDTO.getCuratorId());
        exhibition.setCurator(curator);

        // Save exhibition
        Exhibition savedExhibition = exhibitionRepository.save(exhibition);

        // Create item reservations
        for (Integer itemId : createExhibitionDTO.getItemIds()) {
            Item item = itemService.findById(itemId);
            // Create and save reservation
            ItemReservation itemReservation = new ItemReservation(item, savedExhibition,
                    proposal.getStartDate(), proposal.getEndDate());
            itemReservationService.save(itemReservation);
        }

        return savedExhibition;
    }

    @Transactional
    public Exhibition updateExhibition(Integer id, CreateExhibitionDTO exhibitionDTO) {
        Exhibition exhibition = findById(id);

        if (exhibition == null) {
            throw new EntityNotFoundException("Exhibition not found");
        }

        // Update basic details
        exhibition.setName(exhibitionDTO.getName());
        exhibition.setTheme(exhibitionDTO.getTheme());
        exhibition.setShortDescription(exhibitionDTO.getShortDescription());
        exhibition.setLongDescription(exhibitionDTO.getLongDescription());
        exhibition.setPicture(exhibitionDTO.getPicture());

        // Handle item reservations
        List<ItemReservation> existingReservations = exhibition.getItemReservations();
        List<Integer> newItemIds = exhibitionDTO.getItemIds(); // List of item IDs from the DTO
        LocalDate startDate = exhibition.getExhibitionProposal().getStartDate();
        LocalDate endDate = exhibition.getExhibitionProposal().getEndDate();

        // Fetch the actual Item entities based on the provided IDs
        Collection<Item> newItems = itemService.findAllByIds(newItemIds);

        // Remove reservations that are no longer needed
        List<ItemReservation> toRemove = existingReservations.stream()
                .filter(ir -> !newItems.contains(ir.getItem()))
                .toList();

        for (ItemReservation reservation : toRemove) {
            exhibition.getItemReservations().remove(reservation);
            itemReservationService.delete(reservation); // Ovo je bitno za pravilno brisanje
        }


        // Add new reservations
        List<ItemReservation> toAdd = newItems.stream()
                .filter(item -> existingReservations.stream()
                        .noneMatch(ir -> ir.getItem().equals(item)))
                .map(item -> new ItemReservation(item, exhibition, startDate, endDate))
                .toList();

        exhibition.getItemReservations().addAll(toAdd);

        return exhibitionRepository.save(exhibition);
    }



}

