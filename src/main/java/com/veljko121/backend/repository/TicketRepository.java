package com.veljko121.backend.repository;

import com.veljko121.backend.model.Exhibition;
import com.veljko121.backend.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    List<Ticket> findByGuestId(Integer guestId);

    boolean existsByExhibitionIdAndGuestId(Integer exhibitionId, Integer guestId);
}
