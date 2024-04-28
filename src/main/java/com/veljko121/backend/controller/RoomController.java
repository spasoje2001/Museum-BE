package com.veljko121.backend.controller;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.veljko121.backend.model.Room;
import com.veljko121.backend.service.IRoomReservationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final IRoomReservationService roomReservationService;

    private final ModelMapper modelMapper;

    @GetMapping(path = "/available")
    public ResponseEntity<?> getAvailableRoomsByTimespan(@RequestParam String startDateTime, @RequestParam Integer durationMinutes) {
        var rooms = roomReservationService.findAvailableRoomsByTimespan(LocalDateTime.parse(startDateTime), durationMinutes);
        var response = rooms.stream()
            .map(room -> modelMapper.map(room, Room.class))
            .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    
}
