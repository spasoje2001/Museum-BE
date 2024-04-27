package com.veljko121.backend.controller;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RestController;

import com.veljko121.backend.core.service.IJwtService;
import com.veljko121.backend.service.IEventService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class EventController {
    
    private final IEventService eventService;
    private final IJwtService jwtService;

    private final ModelMapper modelMapper;
    private final Logger logger;

}
