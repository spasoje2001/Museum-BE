package com.veljko121.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veljko121.backend.model.Event;

public interface EventRepository extends JpaRepository<Event, Integer> { }
