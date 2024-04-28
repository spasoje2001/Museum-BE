package com.veljko121.backend.repository.tours;

import com.veljko121.backend.model.tours.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TourRepository extends JpaRepository<Tour, Integer> {

    @Query("SELECT t FROM Tour t WHERE t.organizer.id = ?1")
    List<Tour> findByOrganizerId(Integer organizerId);

}
