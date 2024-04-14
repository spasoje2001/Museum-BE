package com.veljko121.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.veljko121.backend.model.PersonalTour;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonalTourRepository extends JpaRepository<PersonalTour, Integer> {

    @Query("SELECT t FROM PersonalTour t WHERE t.proposer.id = ?1")
    List<PersonalTour> findByGuestId(Integer guestId);

}
