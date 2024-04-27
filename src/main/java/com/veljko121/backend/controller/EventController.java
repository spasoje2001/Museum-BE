package com.veljko121.backend.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veljko121.backend.core.service.IJwtService;
import com.veljko121.backend.dto.EventRequestDTO;
import com.veljko121.backend.dto.EventResponseDTO;
import com.veljko121.backend.model.Event;
import com.veljko121.backend.service.IEventService;
import com.veljko121.backend.service.IOrganizerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventController {
    
    private final IEventService eventService;
    private final IOrganizerService organizerService;
    private final IJwtService jwtService;

    private final ModelMapper modelMapper;
    private final Logger logger;

    @GetMapping(path = "{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        var event = eventService.findById(id);
        var eventResponse = modelMapper.map(event, EventResponseDTO.class);
        return ResponseEntity.ok().body(eventResponse);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        var events = eventService.findAll();
        var response = events.stream()
                .map(tour -> modelMapper.map(tour, Event.class))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    @PreAuthorize("hasRole('ORGANIZER')")
    public ResponseEntity<?> create(@RequestBody EventRequestDTO requestDTO) {
        var event = modelMapper.map(requestDTO, Event.class);
        event.setOrganizer(organizerService.findById(jwtService.getLoggedInUserId()));
        eventService.save(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(requestDTO);
    }

}
