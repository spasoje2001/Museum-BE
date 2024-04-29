package com.veljko121.backend.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.veljko121.backend.dto.EventRequestDTO;
import com.veljko121.backend.model.Event;

@Configuration
public class ModelMapperConfig {
    
    @Bean
    public ModelMapper modelMapper() {
        var modelMapper = new ModelMapper();

        // events
        // var eventTypeMap = modelMapper.getTypeMap(EventRequestDTO.class, Event.class);
        modelMapper.typeMap(EventRequestDTO.class, Event.class).addMapping(src -> src.getRoomId(), (dest, value) -> dest.getRoomReservation().getRoom().setId((Integer)value));

        return modelMapper;
    }

}
