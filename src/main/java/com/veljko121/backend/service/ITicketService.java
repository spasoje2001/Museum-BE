package com.veljko121.backend.service;

import com.veljko121.backend.core.service.ICRUDService;
import com.veljko121.backend.dto.BookTicketsDTO;
import com.veljko121.backend.model.Review;
import com.veljko121.backend.model.Room;
import com.veljko121.backend.model.Ticket;

import java.util.List;

public interface ITicketService extends ICRUDService<Ticket, Integer> {
    public Ticket bookTickets(BookTicketsDTO dto);

    public List<Ticket> getTicketsByGuestId(Integer guestId);

    boolean hasUserPurchasedTicket(Integer exhibitionId, Integer guestId);
}
