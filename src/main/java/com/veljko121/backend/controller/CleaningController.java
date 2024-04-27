package com.veljko121.backend.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veljko121.backend.core.service.IJwtService;
import com.veljko121.backend.dto.CleaningCreateDTO;
import com.veljko121.backend.model.Cleaning;
import com.veljko121.backend.service.ICleaningService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/cleaning")
@RequiredArgsConstructor
public class CleaningController {
    
    private final ModelMapper modelMapper;
    private final ICleaningService cleaningService;
    private final IJwtService jwtService;


     // POST method to add a cleaning to an item
    @PostMapping("/{itemId}")
    public ResponseEntity<Cleaning> addCleaningToItem(@PathVariable Integer itemId, @RequestBody CleaningCreateDTO cleaningDTO) {
        var cleaning = modelMapper.map(cleaningDTO, Cleaning.class);
        Integer userId = jwtService.getLoggedInUserId();
        Cleaning savedCleaning = cleaningService.save(itemId, cleaning,userId);
        return new ResponseEntity<>(savedCleaning, HttpStatus.CREATED);
    }

   // PUT method to decline cleaning for an item
    @PutMapping("/decline/{itemId}/{curatorId}")
    public ResponseEntity<Void> declineCleaning(@PathVariable Integer itemId, @PathVariable Integer curatorId) {
        cleaningService.declineCleaning(itemId, curatorId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // PUT method to approve cleaning for an item
    @PutMapping("/approve/{itemId}/{curatorId}")
    public ResponseEntity<Void> approveCleaning(@PathVariable Integer itemId, @PathVariable Integer curatorId) {
        cleaningService.acceptCleaning(itemId, curatorId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/new")
    public List<Cleaning> getAllNewCleanings() {
        return cleaningService.getAllNewCleanings();
    }
}
