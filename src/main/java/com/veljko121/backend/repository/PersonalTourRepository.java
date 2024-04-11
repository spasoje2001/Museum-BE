package com.veljko121.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.veljko121.backend.model.PersonalTour;

public interface PersonalTourRepository extends JpaRepository<PersonalTour, Integer> {

}
