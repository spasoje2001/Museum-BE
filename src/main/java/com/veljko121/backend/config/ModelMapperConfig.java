package com.veljko121.backend.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.veljko121.backend.dto.EventRequestDTO;
import com.veljko121.backend.dto.EventUpdateRequestDTO;
import com.veljko121.backend.model.Event;

@Configuration
public class ModelMapperConfig {
    
    @Bean
    public ModelMapper modelMapper() {
        var modelMapper = new ModelMapper();

        // events
        modelMapper.typeMap(EventRequestDTO.class, Event.class).addMapping(src -> src.getRoomId(), (dest, value) -> dest.getRoomReservation().getRoom().setId((Integer)value));
        modelMapper.typeMap(EventRequestDTO.class, Event.class).addMappings(new PropertyMap<EventRequestDTO, Event>() {
            @Override
            protected void configure() {
                skip(destination.getId());
            }
        });
        modelMapper.typeMap(EventUpdateRequestDTO.class, Event.class).addMapping(src -> src.getRoomId(), (dest, value) -> dest.getRoomReservation().getRoom().setId((Integer)value));

        return modelMapper;
    }

}
