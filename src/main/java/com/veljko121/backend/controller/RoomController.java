package com.veljko121.backend.controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    private final ModelMapper modelMapper;

    @GetMapping("/availableDates")
    public ResponseEntity<?> getAvailableRooms(
            @RequestParam("startDate") @DateTimeFormat(pattern = "dd.MM.yyyy.") String startDateStr,
            @RequestParam("endDate") @DateTimeFormat(pattern = "dd.MM.yyyy.") String endDateStr) {
        try {
            // Convert String to Date
            LocalDate startDate = DateUtil.stringToDate(startDateStr);
            LocalDate endDate = DateUtil.stringToDate(endDateStr);

            // Call the service method to find available rooms
            List<Room> availableRooms = roomService.findAvailableRooms(startDate, endDate);

            // If you have a RoomDTO, map the Room entities to RoomDTOs
            // Otherwise, directly return the Room entities
            // Replace 'RoomResponse' with your actual DTO class if you have one
            var response = availableRooms.stream()
                    .map(room -> modelMapper.map(room, Room.class))
                    .collect(Collectors.toList());

            return ResponseEntity.ok(response);
        } catch (DateTimeParseException e) {
            return ResponseEntity.badRequest().body("Invalid date format. Please use the pattern dd.MM.yyyy.");
        }
    }


    @GetMapping
    public ResponseEntity<?> findAll() {
        List<Room> rooms = roomService.findAll();
        var roomsResponse = rooms.stream()
                .map(tour -> modelMapper.map(tour, Room.class))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.CREATED).body(roomsResponse);
    }
    
}
