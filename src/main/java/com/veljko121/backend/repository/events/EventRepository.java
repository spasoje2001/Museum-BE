package com.veljko121.backend.repository.events;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veljko121.backend.core.enums.EventStatus;
import com.veljko121.backend.model.Event;
import com.veljko121.backend.model.Organizer;

public interface EventRepository extends JpaRepository<Event, Integer> { 

    List<Event> findByStatus(EventStatus status);

    List<Event> findByOrganizer(Organizer organizer);

 }
