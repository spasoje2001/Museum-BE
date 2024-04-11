package com.veljko121.backend.controller;

import com.veljko121.backend.service.IPersonalTourService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import com.veljko121.backend.dto.PersonalTourCreateDTO;
import com.veljko121.backend.model.PersonalTour;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/personalTours")
@RequiredArgsConstructor
public class PersonalTourController {

    private final IPersonalTourService personalTourService;

    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody PersonalTourCreateDTO tour) {
        return ResponseEntity.ok().body(personalTourService.save(modelMapper.map(tour, PersonalTour.class)));
    }
}
