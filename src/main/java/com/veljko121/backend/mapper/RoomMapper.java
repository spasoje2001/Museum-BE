package com.veljko121.backend.mapper;

import com.veljko121.backend.dto.ExhibitionResponseDTO;
import com.veljko121.backend.dto.ItemReservationResponseDTO;
import com.veljko121.backend.dto.RoomResponseDTO;
import com.veljko121.backend.model.Exhibition;
import com.veljko121.backend.model.ExhibitionProposal;
import com.veljko121.backend.model.Room;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoomMapper {

    public RoomResponseDTO mapToDTO(Room room) {
        RoomResponseDTO dto = new RoomResponseDTO();
        dto.setId(room.getId());
        dto.setName(room.getName());
        dto.setNumber(room.getNumber());

        return dto;
    }
}
