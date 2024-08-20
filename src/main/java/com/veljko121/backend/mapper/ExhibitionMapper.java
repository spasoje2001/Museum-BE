package com.veljko121.backend.mapper;

import com.veljko121.backend.dto.*;
import com.veljko121.backend.model.*;
import com.veljko121.backend.util.DateUtil;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ExhibitionMapper {
    public ExhibitionResponseDTO mapToDTO(Exhibition exhibition) {
        ExhibitionResponseDTO dto = new ExhibitionResponseDTO();
        dto.setId(exhibition.getId());
        dto.setName(exhibition.getName());
        dto.setPicture(exhibition.getPicture());
        dto.setShortDescription(exhibition.getShortDescription());
        dto.setLongDescription(exhibition.getLongDescription());
        dto.setTheme(exhibition.getTheme());
        dto.setStatus(exhibition.getStatus());
        dto.setCurator(mapToCuratorDTO(exhibition.getCurator()));

        // Map ExhibitionProposal properties
        ExhibitionProposal proposal = exhibition.getExhibitionProposal();
        dto.setProposal(mapToProposalDTO(proposal));

        // Map item reservations
        List<ItemReservationResponseDTO> itemReservationsDTO = exhibition.getItemReservations()
                .stream()
                .map(this::mapToItemReservationDTO)
                .collect(Collectors.toList());
        dto.setItemReservations(itemReservationsDTO);

        return dto;
    }

    private ExhibitionProposalResponseDTO mapToProposalDTO(ExhibitionProposal proposal) {
        if (proposal == null) {
            return null;
        }

        ExhibitionProposalResponseDTO proposalDTO = new ExhibitionProposalResponseDTO();
        proposalDTO.setId(proposal.getId());
        proposalDTO.setStartDate(DateUtil.dateToString(proposal.getStartDate()));
        proposalDTO.setEndDate(DateUtil.dateToString(proposal.getEndDate()));

        // Map the organizer details to OrganizerResponseDTO
        proposalDTO.setOrganizer(mapToOrganizerDTO(proposal.getOrganizer()));

        // Map the room details to RoomResponseDTO
        proposalDTO.setRoomReservation(mapToRoomReservationDTO(proposal.getRoomReservation()));

        // Map the price list details to ExhibitionPriceListResponseDTO
        proposalDTO.setPriceList(mapToPriceListDTO(proposal.getExhibitionPriceList()));

        return proposalDTO;
    }



    private OrganizerResponseDTO mapToOrganizerDTO(Organizer organizer) {
        if (organizer == null) {
            return null; // Return null if the input is null
        }
        OrganizerResponseDTO organizerDTO = new OrganizerResponseDTO();
        organizerDTO.setId(organizer.getId());
        organizerDTO.setUsername(organizer.getUsername());
        organizerDTO.setEmail(organizer.getEmail());
        organizerDTO.setFirstName(organizer.getFirstName());
        organizerDTO.setLastName(organizer.getLastName());
        organizerDTO.setRole(organizer.getRole()); // Assuming Role is an enum
        organizerDTO.setBiography(organizer.getBiography());
        // Map organizer properties
        return organizerDTO;
    }

    private CuratorResponseDTO mapToCuratorDTO(Curator curator) {
        if (curator == null) {
            return null; // Return null if the input is null
        }
        CuratorResponseDTO curatorDTO = new CuratorResponseDTO();
        curatorDTO.setId(curator.getId());
        curatorDTO.setUsername(curator.getUsername());
        curatorDTO.setEmail(curator.getEmail());
        curatorDTO.setFirstName(curator.getFirstName());
        curatorDTO.setLastName(curator.getLastName());
        curatorDTO.setRole(curator.getRole()); // Assuming Role is an enum
        curatorDTO.setBiography(curator.getBiography());
        // Map curator properties
        return curatorDTO;
    }

    private ExhibitionPriceListResponseDTO mapToPriceListDTO(ExhibitionPriceList priceList) {
        if (priceList == null) {
            return null;
        }

        ExhibitionPriceListResponseDTO priceListDTO = new ExhibitionPriceListResponseDTO();
        priceListDTO.setAdultPrice(priceList.getAdultTicketPrice());  // Map the adult price
        priceListDTO.setMinorPrice(priceList.getMinorTicketPrice());  // Map the children price

        return priceListDTO;
    }

    private ItemReservationResponseDTO mapToItemReservationDTO(ItemReservation itemReservation) {
        if (itemReservation == null) {
            return null;
        }

        ItemReservationResponseDTO itemReservationDTO = new ItemReservationResponseDTO();
        itemReservationDTO.setId(itemReservation.getId());
        itemReservationDTO.setStartDate(DateUtil.dateToString(itemReservation.getStartDate()));  // Assuming LocalDate or LocalDateTime
        itemReservationDTO.setEndDate(DateUtil.dateToString(itemReservation.getEndDate()));  // Assuming LocalDate or LocalDateTime
        itemReservationDTO.setItem(mapToItemDTO(itemReservation.getItem()));  // Map the associated Item to ItemResponseDTO

        return itemReservationDTO;
    }

    private ItemResponseDTO mapToItemDTO(Item item) {
        if (item == null) {
            return null;
        }

        ItemResponseDTO itemDTO = new ItemResponseDTO();
        itemDTO.setId(item.getId());
        itemDTO.setName(item.getName());
        itemDTO.setDescription(item.getDescription());
        itemDTO.setAuthorsName(item.getAuthorsName());
        itemDTO.setYearOfCreation(item.getYearOfCreation());
        itemDTO.setPeriod(item.getPeriod());
        itemDTO.setCategory(item.getCategory());
        itemDTO.setPicture(item.getPicture());

        return itemDTO;
    }

    private RoomReservationResponseDTO mapToRoomReservationDTO(RoomReservation roomReservation) {
        if (roomReservation == null) {
            return null; // Return null if the input is null
        }
        RoomReservationResponseDTO roomDTO = new RoomReservationResponseDTO();
        roomDTO.setId(roomReservation.getId());
        roomDTO.setStartDate(DateUtil.dateToString(roomReservation.getStartDate()));
        roomDTO.setEndDate(DateUtil.dateToString(roomReservation.getEndDate()));
        roomDTO.setRoom(mapToRoomDTO(roomReservation.getRoom()));

        return roomDTO;
    }

    private RoomResponseDTO mapToRoomDTO(Room room){
        if (room == null){
            return null;
        }
        RoomResponseDTO roomDTO = new RoomResponseDTO();
        roomDTO.setId(room.getId());
        roomDTO.setName(room.getName());
        roomDTO.setNumber(room.getNumber());
        return roomDTO;
    }




}
