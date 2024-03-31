package com.veljko121.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veljko121.backend.model.Guest;

public interface GuestRepository extends JpaRepository<Guest, Integer> { }
