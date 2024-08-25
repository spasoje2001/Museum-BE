package com.veljko121.backend.controller;

import com.veljko121.backend.dto.ExhibitionProposalDTO;
import com.veljko121.backend.dto.ExhibitionProposalResponseDTO;
import com.veljko121.backend.dto.ExhibitionResponseDTO;
import com.veljko121.backend.dto.ItemCreateDTO;
import com.veljko121.backend.mapper.ExhibitionMapper;
import com.veljko121.backend.model.Exhibition;
import com.veljko121.backend.model.ExhibitionProposal;
import com.veljko121.backend.model.Item;
import com.veljko121.backend.service.IExhibitionProposalService;
import com.veljko121.backend.service.IExhibitionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/proposals")
@RequiredArgsConstructor
public class ExhibitionProposalController {
    private final IExhibitionProposalService proposalService;

    private final ExhibitionMapper exhibitionMapper;

    @PostMapping
    public ResponseEntity<ExhibitionProposalResponseDTO> create(@RequestBody ExhibitionProposalDTO proposalDTO) {
        ExhibitionProposal proposal = proposalService.createProposal(proposalDTO);
        ExhibitionProposalResponseDTO dto = exhibitionMapper.mapToProposalDTO(proposal);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping("/organizer/{organizerId}")
    public ResponseEntity<?> getProposalsByOrganizer(@PathVariable Integer organizerId) {
        var proposals = proposalService.findByOrganizerId(organizerId);
        var response = proposals.stream()
                .map(exhibitionMapper::mapToProposalDTO)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
