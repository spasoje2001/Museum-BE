package com.veljko121.backend.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veljko121.backend.dto.ItemDTO;
import com.veljko121.backend.model.Item;
import com.veljko121.backend.service.IItemService;

import ch.qos.logback.classic.Logger;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ItemContoller {

    private final ModelMapper modelMapper;
    private final IItemService itemService;
    private final Logger logger;


    @PostMapping("/add")
    public ResponseEntity<?> register(@Valid @RequestBody ItemDTO itemDTO) {

        var item = modelMapper.map(itemDTO, Item.class);
        itemService.save(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(itemDTO);

    }

    @GetMapping("/")
    public ResponseEntity<?> finAll() {

        List<Item> items = itemService.findAll();
        var itemResponse = items.stream()
                .map(tour -> modelMapper.map(tour, Item.class))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.CREATED).body(itemResponse);

    }
}
