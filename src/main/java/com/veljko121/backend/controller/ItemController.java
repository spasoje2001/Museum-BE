package com.veljko121.backend.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.veljko121.backend.dto.ItemCreateDTO;
import com.veljko121.backend.dto.ItemResponseDTO;
import com.veljko121.backend.dto.ItemUpdateDTO;
import com.veljko121.backend.dto.RoomResponseDTO;
import com.veljko121.backend.model.Item;
import com.veljko121.backend.service.IItemService;
import com.veljko121.backend.util.DateUtil;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ItemController {

    private final ModelMapper modelMapper;
    private final IItemService itemService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ItemCreateDTO itemDTO) {
        var item = modelMapper.map(itemDTO, Item.class);
        itemService.save(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(itemDTO);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<Item> items = itemService.findAll();
        var itemResponse = items.stream()
                .map(item -> modelMapper.map(item, ItemResponseDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(itemResponse);
    }

    @GetMapping("/available")
    public ResponseEntity<List<ItemResponseDTO>> getAvailableItems(@RequestParam String startDate,
                                                                   @RequestParam String endDate) {
        LocalDate start = DateUtil.stringToDate(startDate);
        LocalDate end = DateUtil.stringToDate(endDate);


        List<Item> items = itemService.findAvailableItems(start, end);
        var itemResponse = items.stream()
                .map(item -> modelMapper.map(item, ItemResponseDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(itemResponse);
    }

    @GetMapping("/availableForUpdate")
    public ResponseEntity<List<ItemResponseDTO>> getAvailableItemsForUpdate(@RequestParam String startDate,
                                                                            @RequestParam String endDate,
                                                                            @RequestParam Integer exhibitionId) {
        LocalDate start = DateUtil.stringToDate(startDate);
        LocalDate end = DateUtil.stringToDate(endDate);

        List<Item> items = itemService.findAvailableItemsForUpdate(start, end, exhibitionId);
        var itemResponse = items.stream()
                .map(item -> modelMapper.map(item, ItemResponseDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(itemResponse);
    }

    @GetMapping("/{itemId}")
    public Item getItem(@PathVariable Integer itemId) {
        return itemService.findById(itemId);
    }

    @PutMapping
    public ResponseEntity<?> updateItem(@RequestBody ItemUpdateDTO itemDTO){
        var item =itemService.findById(itemDTO.getId());
        item.setAuthorsName(itemDTO.getAuthorsName());
        item.setCategory(itemDTO.getCategory());
        item.setDescription(itemDTO.getDescription());
        item.setName(itemDTO.getName());
        item.setPeriod(itemDTO.getPeriod());
        item.setPicture(itemDTO.getPicture());
        item.setYearOfCreation(itemDTO.getYearOfCreation());
        itemService.update(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(itemDTO);
    }


    @GetMapping("/search/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name) {
        List<Item> items = itemService.findByName(name);
        var itemResponse = items.stream()
                .map(tour -> modelMapper.map(tour, Item.class))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(itemResponse);
    }

}
