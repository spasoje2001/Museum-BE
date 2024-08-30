package com.veljko121.backend.repository;

import java.util.List;
import java.util.Optional;

import com.veljko121.backend.core.enums.ExhibitionTheme;
import com.veljko121.backend.model.Exhibition;
import org.springframework.data.jpa.repository.JpaRepository;

import com.veljko121.backend.model.Guest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GuestRepository extends JpaRepository<Guest, Integer> {

    Optional<Guest> findByUsername(String username);

    @Query("SELECT DISTINCT t.guest FROM Ticket t WHERE t.exhibition.id = :exhibitionId")
    List<Guest> findUsersWithTicketsForExhibition(@Param("exhibitionId") Integer exhibitionId);

    @Query("SELECT DISTINCT t.guest FROM Ticket t WHERE t.exhibition.theme = :theme")
    List<Guest> findUsersInterestedInTheme(@Param("theme") ExhibitionTheme theme);

    @Query("SELECT DISTINCT r.guest FROM Review r WHERE r.exhibition = :exhibition")
    List<Guest> findUsersWhoReviewedExhibition(@Param("exhibition") Exhibition exhibition);

    @Query("SELECT g FROM Guest g WHERE g NOT IN (SELECT t.guest FROM Ticket t WHERE t.exhibition = :exhibition)")
    List<Guest> findUsersWithoutTicketsForExhibition(@Param("exhibition") Exhibition exhibition);

}
