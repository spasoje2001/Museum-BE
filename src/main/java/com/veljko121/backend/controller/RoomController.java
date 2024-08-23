package com.veljko121.backend.controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.veljko121.backend.dto.RoomResponseDTO;
import com.veljko121.backend.mapper.ExhibitionMapper;
import com.veljko121.backend.mapper.RoomMapper;
import com.veljko121.backend.util.DateUtil;
import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.veljko121.backend.model.Room;
import com.veljko121.backend.service.IRoomReservationService;
import com.veljko121.backend.service.IRoomService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final IRoomReservationService roomReservationService;
    private final IRoomService roomService;

    private final RoomMapper roomMapper;


    @GetMapping("/available")
    public ResponseEntity<List<RoomResponseDTO>> getAvailableRooms(@RequestParam String startDate,
                                                                   @RequestParam String endDate) {
        LocalDate start = DateUtil.stringToDate(startDate);
        LocalDate end = DateUtil.stringToDate(endDate);

        var rooms = roomService.findAvailableRooms(start,end);
        var response = rooms.stream()
                .map(roomMapper::mapToDTO)
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        var exhibitions = roomService.findAll();
        var response = exhibitions.stream()
                .map(roomMapper::mapToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    
}
