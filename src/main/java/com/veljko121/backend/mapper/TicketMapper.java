package com.veljko121.backend.mapper;

import com.veljko121.backend.dto.ExhibitionResponseDTO;
import com.veljko121.backend.dto.ItemReservationResponseDTO;
import com.veljko121.backend.dto.TicketResponseDTO;
import com.veljko121.backend.model.Exhibition;
import com.veljko121.backend.model.ExhibitionProposal;
import com.veljko121.backend.model.Ticket;
import com.veljko121.backend.util.DateUtil;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TicketMapper {
    public TicketResponseDTO mapToDTO(Ticket ticket) {
        TicketResponseDTO dto = new TicketResponseDTO();
        dto.setId(ticket.getId());
        dto.setNumberOfAdults(ticket.getNumberOfAdults());
        dto.setNumberOfMinors(ticket.getNumberOfMinors());
        dto.setTotalPrice(ticket.getTotalPrice());

        dto.setExhibitionId(ticket.getExhibition().getId());
        dto.setExhibitionName(ticket.getExhibition().getName());
        dto.setExhibitionPicture(ticket.getExhibition().getPicture());
        dto.setExhibitionRoomName(ticket.getExhibition().getExhibitionProposal().getRoomReservation().getRoom().getName());
        dto.setExhibitionRoomNumber(ticket.getExhibition().getExhibitionProposal().getRoomReservation().getRoom().getNumber());
        dto.setExhibitionStartDate(DateUtil.dateToString(ticket.getExhibition().getExhibitionProposal().getStartDate()));
        dto.setExhibitionEndDate(DateUtil.dateToString(ticket.getExhibition().getExhibitionProposal().getEndDate()));

        dto.setGuestId(ticket.getGuest().getId());
        dto.setGuestFirstName(ticket.getGuest().getFirstName());
        dto.setGuestLastName(ticket.getGuest().getLastName());

        return dto;
    }
}
