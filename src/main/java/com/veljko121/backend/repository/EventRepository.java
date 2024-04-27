package com.veljko121.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veljko121.backend.core.enums.EventStatus;
import com.veljko121.backend.model.Event;

public interface EventRepository extends JpaRepository<Event, Integer> { 

    List<Event> findByStatus(EventStatus status);

 }
