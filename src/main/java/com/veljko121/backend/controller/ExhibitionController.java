package com.veljko121.backend.controller;

import com.veljko121.backend.dto.CreateExhibitionDTO;
import com.veljko121.backend.dto.ExhibitionProposalDTO;
import com.veljko121.backend.dto.ExhibitionProposalResponseDTO;
import com.veljko121.backend.dto.ExhibitionResponseDTO;
import com.veljko121.backend.mapper.ExhibitionMapper;
import com.veljko121.backend.model.Exhibition;
import com.veljko121.backend.model.ExhibitionProposal;
import com.veljko121.backend.service.IExhibitionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/exhibitions")
@RequiredArgsConstructor
public class ExhibitionController {

    private final IExhibitionService exhibitionService;
    private final ModelMapper modelMapper;
    private final ExhibitionMapper exhibitionMapper;

    @GetMapping(path = "{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        var exhibition = exhibitionService.findById(id);
        var exhibitionResponse = exhibitionMapper.mapToDTO(exhibition);
        return ResponseEntity.ok().body(exhibitionResponse);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        var exhibitions = exhibitionService.findAll();
        var response = exhibitions.stream()
                .map(exhibitionMapper::mapToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/organizer/{organizerId}")
    public ResponseEntity<?> getExhibitionsByOrganizer(@PathVariable Integer organizerId) {
        var exhibitions = exhibitionService.findByOrganizerId(organizerId);
        var response = exhibitions.stream()
                .map(exhibitionMapper::mapToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/curator/{curatorId}")
    public ResponseEntity<?> getExhibitionsByCurator(@PathVariable Integer curatorId) {
        var exhibitions = exhibitionService.findByCuratorId(curatorId);
        var response = exhibitions.stream()
                .map(exhibitionMapper::mapToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @PostMapping
    public ResponseEntity<?> createExhibition(@RequestBody @Valid CreateExhibitionDTO createExhibitionDTO) {
        Exhibition exhibition = exhibitionService.createExhibition(createExhibitionDTO);
        var exhibitionResponse = exhibitionMapper.mapToDTO(exhibition);
        return ResponseEntity.status(HttpStatus.CREATED).body(exhibitionResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExhibitionResponseDTO> updateExhibition(@PathVariable Integer id, @RequestBody CreateExhibitionDTO exhibitionDTO) {
        Exhibition updatedExhibition = exhibitionService.updateExhibition(id, exhibitionDTO);
        ExhibitionResponseDTO dto = exhibitionMapper.mapToDTO(updatedExhibition);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

}
