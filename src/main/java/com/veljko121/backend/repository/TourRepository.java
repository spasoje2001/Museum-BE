package com.veljko121.backend.repository;

import com.veljko121.backend.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourRepository extends JpaRepository<Tour, Integer> {

}
