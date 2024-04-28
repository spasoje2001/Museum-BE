package com.veljko121.backend.controller;

import com.veljko121.backend.core.service.IJwtService;
import com.veljko121.backend.dto.tours.PersonalTourCreateDTO;
import com.veljko121.backend.dto.tours.PersonalTourResponseDTO;
import com.veljko121.backend.service.ICuratorService;
import com.veljko121.backend.service.IOrganizerService;
import com.veljko121.backend.service.IPersonalTourService;
import com.veljko121.backend.service.impl.GuestService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.veljko121.backend.model.PersonalTour;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/personalTours")
@RequiredArgsConstructor
public class PersonalTourController {

    private final IPersonalTourService personalTourService;
    private final IJwtService jwtService;
    private final IOrganizerService organizerService;
    private final ICuratorService curatorService;

    private final ModelMapper modelMapper;
    private final GuestService guestService;

    @PostMapping
    @PreAuthorize("hasRole('OGRANIZER')")
    public ResponseEntity<?> create(@RequestBody PersonalTourCreateDTO tourDTO) {
        var tour = modelMapper.map(tourDTO, PersonalTour.class);

        var id = jwtService.getLoggedInUserId();
        tour.setOrganizer(organizerService.findById(id));
        tour.setProposer(guestService.findById(tourDTO.getProposerId()));
        tour.setGuide(curatorService.findById(tourDTO.getGuideId()));

        personalTourService.save(tour);

        return ResponseEntity.status(HttpStatus.CREATED).body(tourDTO);
    }

    @GetMapping("/{guestId}")
    @PreAuthorize("hasRole('GUEST')")
    public ResponseEntity<?> findByGuestId(@PathVariable Integer guestId) {
        List<PersonalTour> tours = personalTourService.findByGuestId(guestId);
        var tourResponse = tours.stream()
                .map(tour -> modelMapper.map(tour, PersonalTourResponseDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(tourResponse);
    }

}
