package com.veljko121.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.veljko121.backend.model.Organizer;
public interface OrganizerRepository extends JpaRepository<Organizer, Integer> {}