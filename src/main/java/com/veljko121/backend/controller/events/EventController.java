package com.veljko121.backend.controller.events;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veljko121.backend.core.service.IJwtService;
import com.veljko121.backend.dto.events.EventRequestDTO;
import com.veljko121.backend.dto.events.EventResponseDTO;
import com.veljko121.backend.dto.events.EventUpdateRequestDTO;
import com.veljko121.backend.model.Organizer;
import com.veljko121.backend.model.events.Event;
import com.veljko121.backend.model.events.EventPicture;
import com.veljko121.backend.service.IOrganizerService;
import com.veljko121.backend.service.events.IEventService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventController {
    
    private final IEventService eventService;
    private final IOrganizerService organizerService;
    private final IJwtService jwtService;

    private final ModelMapper modelMapper;

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
        var event = mapRequestToEvent(requestDTO);
        eventService.save(event);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @PutMapping
    @PreAuthorize("hasRole('ORGANIZER')")
    public ResponseEntity<?> update(@RequestBody EventUpdateRequestDTO requestDTO) {
        var event = mapUpdateRequestToEvent(requestDTO);
        eventService.update(event);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @PatchMapping(path = "{id}/publish")
    @PreAuthorize("hasRole('ORGANIZER')")
    public ResponseEntity<?> publish(@PathVariable Integer id) {
        var organizer = getLoggedInOrganizer();
        var event = eventService.findById(id);
        
        if (!event.getOrganizer().equals(organizer)) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        
        eventService.publish(id);
        
        return ResponseEntity.ok().build();
    }
    
    @PatchMapping(path = "{id}/archive")
    @PreAuthorize("hasRole('ORGANIZER')")
    public ResponseEntity<?> archive(@PathVariable Integer id) {
        var organizer = getLoggedInOrganizer();
        var event = eventService.findById(id);
        
        if (!event.getOrganizer().equals(organizer)) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        
        eventService.archive(id);
        
        return ResponseEntity.ok().build();
    }
    
    @GetMapping(path = "published")
    public ResponseEntity<?> getAllPublished() {
        var events = eventService.findPublished();
        var response = events.stream()
        .map(tour -> modelMapper.map(tour, Event.class))
        .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    
    @GetMapping(path = "my")
    @PreAuthorize("hasRole('ORGANIZER')")
    public ResponseEntity<?> getEventsByLoggedInOrganizer() {
        var events = eventService.findByOrganizer(getLoggedInOrganizer());
        var response = events.stream()
            .map(tour -> modelMapper.map(tour, Event.class))
            .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    
    @DeleteMapping(path = "{id}")
    @PreAuthorize("hasRole('ORGANIZER')")
    public ResponseEntity<?> deleteEvent(@PathVariable Integer id) {
        var organizer = getLoggedInOrganizer();
        var event = eventService.findById(id);
        
        if (!event.getOrganizer().equals(organizer)) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        eventService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    
    private Organizer getLoggedInOrganizer() {
        return organizerService.findById(jwtService.getLoggedInUserId());
    }

    private Event mapRequestToEvent(EventRequestDTO requestDTO) {
        var event = modelMapper.map(requestDTO, Event.class);
        event.setOrganizer(getLoggedInOrganizer());

        Collection<EventPicture> eventPictures = new ArrayList<>();
        for (var picturePath : requestDTO.getPicturePaths()) {
            var eventPicture = new EventPicture();
            eventPicture.setPath(picturePath);
            eventPictures.add(eventPicture);
        }
        event.setPictures(eventPictures);
        return event;
    }

    private Event mapUpdateRequestToEvent(EventUpdateRequestDTO updateRequestDTO) {
        var event = mapRequestToEvent(new EventRequestDTO(updateRequestDTO));
        event.setId(updateRequestDTO.getId());
        event.setOrganizer(getLoggedInOrganizer());
        Collection<EventPicture> eventPictures = new ArrayList<>();
        for (var picturePath : updateRequestDTO.getPicturePaths()) {
            var eventPicture = new EventPicture();
            eventPicture.setPath(picturePath);
            eventPictures.add(eventPicture);
        }
        event.setPictures(eventPictures);
        return event;
    }

}
