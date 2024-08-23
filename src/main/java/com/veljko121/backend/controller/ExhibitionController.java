package com.veljko121.backend.controller;

import com.veljko121.backend.dto.ExhibitionProposalDTO;
import com.veljko121.backend.dto.ExhibitionResponseDTO;
import com.veljko121.backend.mapper.ExhibitionMapper;
import com.veljko121.backend.model.Exhibition;
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

}
