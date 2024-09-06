package com.veljko121.backend.controller;

import com.veljko121.backend.dto.BookTicketsDTO;
import com.veljko121.backend.dto.ReviewResponseDTO;
import com.veljko121.backend.dto.TicketResponseDTO;
import com.veljko121.backend.mapper.ExhibitionMapper;
import com.veljko121.backend.mapper.TicketMapper;
import com.veljko121.backend.model.Review;
import com.veljko121.backend.model.Ticket;
import com.veljko121.backend.service.IExhibitionService;
import com.veljko121.backend.service.ITicketService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor
public class TicketController {
    private final ITicketService ticketService;
    private final TicketMapper ticketMapper;

    @PostMapping("/book")
    public ResponseEntity<TicketResponseDTO> bookTickets(@RequestBody BookTicketsDTO bookTicketsDTO) {
        Ticket ticket = ticketService.bookTickets(bookTicketsDTO);
        TicketResponseDTO dto = ticketMapper.mapToDTO(ticket);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping("/guest/{guestId}")
    public ResponseEntity<List<TicketResponseDTO>> getTicketsByGuestId(@PathVariable Integer guestId) {
        List<Ticket> tickets = ticketService.getTicketsByGuestId(guestId);

        // Use the mapper to convert the list of Review entities to a list of ReviewResponseDTOs
        List<TicketResponseDTO> ticketResponseDTOS = tickets.stream()
                .map(ticketMapper::mapToDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(ticketResponseDTOS);
    }

    @GetMapping("/exhibition/{exhibitionId}/guest/{guestId}/has-ticket")
    public ResponseEntity<Boolean> hasUserPurchasedTicket(@PathVariable Integer exhibitionId, @PathVariable Integer guestId) {
        boolean hasTicket = ticketService.hasUserPurchasedTicket(exhibitionId, guestId);
        return ResponseEntity.ok(hasTicket);
    }


}
