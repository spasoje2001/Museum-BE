package com.veljko121.backend.controller;

import com.veljko121.backend.dto.PersonalTourRequestCreateDTO;
import com.veljko121.backend.model.PersonalTourRequest;
import com.veljko121.backend.service.IPersonalTourRequestService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/personalTourRequests")
@RequiredArgsConstructor
public class PersonalTourRequestController {

    private final IPersonalTourRequestService personalTourRequestService;

    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody PersonalTourRequestCreateDTO request) {
        return ResponseEntity.ok().body(personalTourRequestService.save(modelMapper.map(request, PersonalTourRequest.class)));
    }
}
