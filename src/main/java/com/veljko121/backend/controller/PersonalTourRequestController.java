package com.veljko121.backend.controller;

import com.veljko121.backend.core.service.IJwtService;
import com.veljko121.backend.dto.Tours.PersonalTourRequestCreateDTO;
import com.veljko121.backend.model.PersonalTourRequest;
import com.veljko121.backend.service.IGuestService;
import com.veljko121.backend.service.IPersonalTourRequestService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/personalTourRequests")
@RequiredArgsConstructor
public class PersonalTourRequestController {

    private final IPersonalTourRequestService personalTourRequestService;
    private final IJwtService jwtService;

    private final ModelMapper modelMapper;
    private final IGuestService guestService;

    @PreAuthorize("hasRole('GUEST')")
    @PostMapping
    public ResponseEntity<?> create(@RequestBody PersonalTourRequestCreateDTO requestDTO) {
        var request = modelMapper.map(requestDTO, PersonalTourRequest.class);

        var id = jwtService.getLoggedInUserId();
        request.setProposer(guestService.findById(id));

        personalTourRequestService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(requestDTO);
    }


}
