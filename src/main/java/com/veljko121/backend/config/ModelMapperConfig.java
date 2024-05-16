package com.veljko121.backend.config;

import java.util.ArrayList;
import java.util.Collection;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.veljko121.backend.dto.EventRequestDTO;
import com.veljko121.backend.dto.EventUpdateRequestDTO;
import com.veljko121.backend.model.Event;
import com.veljko121.backend.model.EventPicture;

@Configuration
public class ModelMapperConfig {
    
    @Bean
    public ModelMapper modelMapper() {
        var modelMapper = new ModelMapper();

        // events
        Converter<Collection<String>, Collection<EventPicture>> picturePathStringsToEventPicture = new Converter<Collection<String>,Collection<EventPicture>>() {
            public Collection<EventPicture> convert(MappingContext<Collection<String>, Collection<EventPicture>> context) {
                Collection<String> picturePaths = context.getSource();
                Collection<EventPicture> eventPictures = new ArrayList<>();
                for (var picturePath : picturePaths) {
                    var eventPicture = new EventPicture();
                    eventPicture.setPath(picturePath);
                    eventPictures.add(eventPicture);
                }
                return eventPictures;
            }
        };
        modelMapper.addConverter(picturePathStringsToEventPicture);
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
