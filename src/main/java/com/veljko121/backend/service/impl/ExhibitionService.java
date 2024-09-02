package com.veljko121.backend.service.impl;

import com.veljko121.backend.core.enums.ExhibitionStatus;
import com.veljko121.backend.core.service.impl.CRUDService;
import com.veljko121.backend.dto.CreateExhibitionDTO;
import com.veljko121.backend.dto.ExhibitionProposalDTO;
import com.veljko121.backend.dto.ExhibitionSearchRequestDTO;
import com.veljko121.backend.mapper.ExhibitionSearchMapper;
import com.veljko121.backend.model.*;
import com.veljko121.backend.repository.ExhibitionRepository;
import com.veljko121.backend.repository.ExhibitionSearchRepository;
import com.veljko121.backend.service.*;
import com.veljko121.backend.util.DateUtil;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;




import java.text.ParseException;
import java.time.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ExhibitionService extends CRUDService<Exhibition, Integer> implements IExhibitionService {
    private final ExhibitionRepository exhibitionRepository;

    private final ExhibitionSearchRepository  exhibitionSearchRepository;

    @Autowired
    private ExhibitionSearchMapper exhibitionSearchMapper;

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

    private static final Logger logger = LoggerFactory.getLogger(ExhibitionService.class);

    public ExhibitionService(ExhibitionRepository repository, ExhibitionSearchRepository searchRepository) {
        super(repository);
        exhibitionRepository = repository;
        exhibitionSearchRepository = searchRepository;
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
    @Transactional
    public List<Exhibition> findAll() {
        updateExhibitionStatuses();
        //updateExhibitionSearchIndex();
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
    @Transactional
    public List<Exhibition> findByOrganizerId(Integer organizerId) {
        updateExhibitionStatuses();
        return exhibitionRepository.findByExhibitionProposalOrganizerId(organizerId);
    }

    @Override
    @Transactional
    public List<Exhibition> findByCuratorId(Integer curatorId) {
        updateExhibitionStatuses();
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

    @Override
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

    @Scheduled(cron = "0 0 0 * * ?") // Podesi da se pokreće svake ponoći
    @Transactional
    public void updateExhibitionStatusesScheduled() {
        updateExhibitionStatuses();
    }

    @Transactional
    public void updateExhibitionStatuses() {
        LocalDate today = LocalDate.now();
        List<Exhibition> exhibitions = exhibitionRepository.findAll();

        for (Exhibition exhibition : exhibitions) {
            LocalDate startDate = exhibition.getExhibitionProposal().getStartDate();
            LocalDate endDate = exhibition.getExhibitionProposal().getEndDate();

            if (today.isBefore(startDate) && exhibition.getStatus() != ExhibitionStatus.READY_TO_OPEN) {
                exhibition.setStatus(ExhibitionStatus.READY_TO_OPEN);
            } else if ((today.isEqual(startDate) || today.isAfter(startDate)) && today.isBefore(endDate) && exhibition.getStatus() != ExhibitionStatus.OPENED) {
                exhibition.setStatus(ExhibitionStatus.OPENED);
            } else if (today.isEqual(endDate) || today.isAfter(endDate) && exhibition.getStatus() != ExhibitionStatus.CLOSED) {
                exhibition.setStatus(ExhibitionStatus.CLOSED);
            }
        }

        exhibitionRepository.saveAll(exhibitions); // Spremi ažurirane statuse
    }

    @Scheduled(initialDelay = 0, fixedRate = 3600000) // podeseno da se pokrene pri pokretanju aplikacije i onda svaki sat nakon toga
    //@Scheduled(cron = "0 0 * * * ?") // Podesi da se pokreće na svakih sat vremena, na pun sat, ali ne nuzno pri pokretanju aplikacije
    @Transactional
    public void updateExhibitionSearchIndex() {
        logger.info("Starting update of ExhibitionSearchIndex");

        List<Exhibition> exhibitions = exhibitionRepository.findAll();
        List<ExhibitionSearch> exhibitionSearches = StreamSupport
                .stream(exhibitionSearchRepository.findAll().spliterator(), false)
                .toList();


        // Kreiramo mapu izložbi iz relacione baze radi bržeg pristupa
        Map<Integer, Exhibition> exhibitionMap = exhibitions.stream()
                .collect(Collectors.toMap(Exhibition::getId, exhibition -> exhibition));

        for (ExhibitionSearch exhibitionSearch : exhibitionSearches) {
            Integer relationalDbId = exhibitionSearch.getRelationalDbId();

            if (exhibitionMap.containsKey(relationalDbId)) {
                // Ako izložba postoji u relacionej bazi, proveravamo da li se podaci razlikuju
                Exhibition exhibition = exhibitionMap.get(relationalDbId);
                ExhibitionSearch updatedExhibitionSearch = exhibitionSearchMapper.toExhibitionSearch(exhibition);

                updatedExhibitionSearch.setId(exhibitionSearch.getId());

                if (!exhibitionSearch.equals(updatedExhibitionSearch)) {
                    // Ažuriramo podatke u Elasticsearch ako se razlikuju
                    exhibitionSearchRepository.save(updatedExhibitionSearch);
                }
            } else {
                // Ako izložba ne postoji u relacionej bazi, brišemo je iz Elasticsearch
                exhibitionSearchRepository.delete(exhibitionSearch);
            }
        }

        // Dodavanje novih izložbi koje nisu u Elasticsearch bazi
        for (Exhibition exhibition : exhibitions) {
            if (exhibitionSearches.stream().noneMatch(es -> es.getRelationalDbId().equals(exhibition.getId()))) {
                ExhibitionSearch newExhibitionSearch = exhibitionSearchMapper.toExhibitionSearch(exhibition);
                exhibitionSearchRepository.save(newExhibitionSearch);
            }
        }

        logger.info("Completed update of ExhibitionSearchIndex");
    }

    @Override
    public List<Exhibition> searchExhibitions(ExhibitionSearchRequestDTO searchRequest) {
        List<Set<Integer>> resultSets = new ArrayList<>();

        if (searchRequest.getName() != null && !searchRequest.getName().isEmpty()) {
            List<ExhibitionSearch> results = exhibitionSearchRepository.findByNameContaining(searchRequest.getName());
            resultSets.add(results.stream().map(ExhibitionSearch::getRelationalDbId).collect(Collectors.toSet()));
        }

        if (searchRequest.getDescription() != null && !searchRequest.getDescription().isEmpty()) {
            List<ExhibitionSearch> shortDescResults = exhibitionSearchRepository.findByShortDescriptionContaining(searchRequest.getDescription());
            List<ExhibitionSearch> longDescResults = exhibitionSearchRepository.findByLongDescriptionContaining(searchRequest.getDescription());

            // Combine results from both searches into one set
            Set<Integer> combinedResultIds = new HashSet<>();
            combinedResultIds.addAll(shortDescResults.stream().map(result -> result.getRelationalDbId()).collect(Collectors.toSet()));
            combinedResultIds.addAll(longDescResults.stream().map(result -> result.getRelationalDbId()).collect(Collectors.toSet()));

            resultSets.add(combinedResultIds);
        }

        if (searchRequest.getTheme() != null) {
            List<ExhibitionSearch> results = exhibitionSearchRepository.findByTheme(searchRequest.getTheme());
            resultSets.add(results.stream().map(ExhibitionSearch::getRelationalDbId).collect(Collectors.toSet()));
        }

        if (searchRequest.getStatus() != null) {
            List<ExhibitionSearch> results = exhibitionSearchRepository.findByStatus(searchRequest.getStatus());
            resultSets.add(results.stream().map(ExhibitionSearch::getRelationalDbId).collect(Collectors.toSet()));
        }

        if (searchRequest.getStartDate() != null && !searchRequest.getStartDate().isEmpty()) {
            List<ExhibitionSearch> results = exhibitionSearchRepository.findByStartDateAfter(DateUtil.stringToDate(searchRequest.getStartDate()));
            resultSets.add(results.stream().map(ExhibitionSearch::getRelationalDbId).collect(Collectors.toSet()));
        }

        if (searchRequest.getEndDate() != null && !searchRequest.getEndDate().isEmpty()) {
            List<ExhibitionSearch> results = exhibitionSearchRepository.findByEndDateBefore(DateUtil.stringToDate(searchRequest.getEndDate()));
            resultSets.add(results.stream().map(ExhibitionSearch::getRelationalDbId).collect(Collectors.toSet()));
        }

        if (searchRequest.getOrganizer() != null && !searchRequest.getOrganizer().isEmpty()) {
            List<ExhibitionSearch> results = exhibitionSearchRepository.findByOrganizerContaining(searchRequest.getOrganizer());
            resultSets.add(results.stream().map(ExhibitionSearch::getRelationalDbId).collect(Collectors.toSet()));
        }

        if (searchRequest.getCurator() != null && !searchRequest.getCurator().isEmpty()) {
            List<ExhibitionSearch> results = exhibitionSearchRepository.findByCuratorContaining(searchRequest.getCurator());
            resultSets.add(results.stream().map(ExhibitionSearch::getRelationalDbId).collect(Collectors.toSet()));
        }

        if (searchRequest.getItemName() != null && !searchRequest.getItemName().isEmpty()) {
            List<ExhibitionSearch> results = exhibitionSearchRepository.findByItems_NameContaining(searchRequest.getItemName());
            resultSets.add(results.stream().map(ExhibitionSearch::getRelationalDbId).collect(Collectors.toSet()));
        }

        if (searchRequest.getItemDescription() != null && !searchRequest.getItemDescription().isEmpty()) {
            List<ExhibitionSearch> results = exhibitionSearchRepository.findByItems_DescriptionContaining(searchRequest.getItemDescription());
            resultSets.add(results.stream().map(ExhibitionSearch::getRelationalDbId).collect(Collectors.toSet()));
        }

        if (searchRequest.getItemAuthorsName() != null && !searchRequest.getItemAuthorsName().isEmpty()) {
            List<ExhibitionSearch> results = exhibitionSearchRepository.findByItems_AuthorsNameContaining(searchRequest.getItemAuthorsName());
            resultSets.add(results.stream().map(ExhibitionSearch::getRelationalDbId).collect(Collectors.toSet()));
        }

        if (searchRequest.getItemCategory() != null) {
            List<ExhibitionSearch> results = exhibitionSearchRepository.findByItems_Category(searchRequest.getItemCategory());
            resultSets.add(results.stream().map(ExhibitionSearch::getRelationalDbId).collect(Collectors.toSet()));
        }

        if (searchRequest.getItemPeriod() != null && !searchRequest.getItemPeriod().isEmpty()) {
            List<ExhibitionSearch> results = exhibitionSearchRepository.findByItems_PeriodContaining(searchRequest.getItemPeriod());
            resultSets.add(results.stream().map(ExhibitionSearch::getRelationalDbId).collect(Collectors.toSet()));
        }

        if (searchRequest.getMinRating() != null) {
            List<ExhibitionSearch> results = exhibitionSearchRepository.findByAverageRatingGreaterThanEqual(searchRequest.getMinRating().doubleValue());
            resultSets.add(results.stream().map(ExhibitionSearch::getRelationalDbId).collect(Collectors.toSet()));
        }

        if (searchRequest.getComment() != null && !searchRequest.getComment().isEmpty()) {
            List<ExhibitionSearch> results = exhibitionSearchRepository.findByReviews_CommentContaining(searchRequest.getComment());
            resultSets.add(results.stream().map(ExhibitionSearch::getRelationalDbId).collect(Collectors.toSet()));
        }

        if (searchRequest.getGuest() != null && !searchRequest.getGuest().isEmpty()) {
            List<ExhibitionSearch> results = exhibitionSearchRepository.findByReviews_GuestNameContaining(searchRequest.getGuest());
            resultSets.add(results.stream().map(ExhibitionSearch::getRelationalDbId).collect(Collectors.toSet()));
        }

        // Intersection of all result sets
        Set<Integer> finalSet = resultSets.stream()
                .reduce((set1, set2) -> {
                    set1.retainAll(set2);
                    return set1;
                })
                .orElse(Collections.emptySet());

        // Find exhibitions in relational database by IDs
        return exhibitionRepository.findAllById(finalSet);
    }


}

