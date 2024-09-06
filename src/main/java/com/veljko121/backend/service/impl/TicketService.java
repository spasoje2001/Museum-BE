package com.veljko121.backend.service.impl;

import com.veljko121.backend.core.service.impl.CRUDService;
import com.veljko121.backend.dto.BookTicketsDTO;
import com.veljko121.backend.model.Exhibition;
import com.veljko121.backend.model.Guest;
import com.veljko121.backend.model.Review;
import com.veljko121.backend.model.Ticket;
import com.veljko121.backend.repository.ExhibitionRepository;
import com.veljko121.backend.repository.TicketRepository;
import com.veljko121.backend.service.ICuratorService;
import com.veljko121.backend.service.IExhibitionService;
import com.veljko121.backend.service.IGuestService;
import com.veljko121.backend.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TicketService extends CRUDService<Ticket, Integer> implements ITicketService {
    private final TicketRepository ticketRepository;

    @Autowired
    private IExhibitionService exhibitionService;

    @Autowired
    private IGuestService guestService;


    public TicketService(TicketRepository repository) {
        super(repository);
        ticketRepository = repository;
    }

    public Ticket bookTickets(BookTicketsDTO bookTicketsDTO) {
        Exhibition exhibition = exhibitionService.findById(bookTicketsDTO.getExhibitionId());
        Guest guest = guestService.findById(bookTicketsDTO.getGuestId());

        Ticket ticket = new Ticket();
        ticket.setExhibition(exhibition);
        ticket.setNumberOfAdults(bookTicketsDTO.getNumberOfAdults());
        ticket.setNumberOfMinors(bookTicketsDTO.getNumberOfMinors());
        ticket.setTotalPrice(bookTicketsDTO.getTotalPrice());
        ticket.setGuest(guest);

        return ticketRepository.save(ticket);
    }

    public List<Ticket> getTicketsByGuestId(Integer guestId) {
        return ticketRepository.findByGuestId(guestId);
    }

    public boolean hasUserPurchasedTicket(Integer exhibitionId, Integer guestId) {
        return ticketRepository.existsByExhibitionIdAndGuestId(exhibitionId, guestId);
    }

}
