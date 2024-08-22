package com.veljko121.backend.service;

import com.veljko121.backend.dto.BookTicketsDTO;
import com.veljko121.backend.model.Review;
import com.veljko121.backend.model.Ticket;

import java.util.List;

public interface ITicketService {
    public Ticket bookTickets(BookTicketsDTO dto);

    public List<Ticket> getTicketsByGuestId(Integer guestId);
}
