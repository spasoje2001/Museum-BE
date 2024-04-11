package com.veljko121.backend.controller;

import com.veljko121.backend.dto.TourCreateDTO;
import com.veljko121.backend.model.Tour;
import com.veljko121.backend.service.ITourService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

@RestController
@RequestMapping("/api/tours")
@RequiredArgsConstructor
public class TourController {

    private final ITourService tourService;

    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody TourCreateDTO tour) {
        return ResponseEntity.ok().body(tourService.save(modelMapper.map(tour, Tour.class)));
    }
}
