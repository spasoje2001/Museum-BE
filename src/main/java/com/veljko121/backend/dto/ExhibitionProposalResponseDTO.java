package com.veljko121.backend.dto;

import lombok.Data;

@Data
public class ExhibitionProposalResponseDTO {
    private Integer id;  // ID of the proposal
    private String startDate;  // Start date of the exhibition
    private String endDate;  // End date of the exhibition
    private OrganizerResponseDTO organizer;  // Details of the organizer
    private RoomReservationResponseDTO room;  // Details of the room reserved for the exhibition
    private ExhibitionPriceListResponseDTO priceList;  // Pricing details for the exhibition
}
