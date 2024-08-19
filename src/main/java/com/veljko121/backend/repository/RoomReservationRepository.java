package com.veljko121.backend.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;

import com.veljko121.backend.model.Room;
import com.veljko121.backend.model.RoomReservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoomReservationRepository extends JpaRepository<RoomReservation, Integer> {

    List<RoomReservation> findByRoom(Room room);

    @Query("SELECT rr FROM RoomReservation rr WHERE rr.room = :room AND rr.endDate > :startDate AND rr.startDate < :endDate")
    List<RoomReservation> findByRoomAndDates(@Param("room") Room room,
                                             @Param("startDate") LocalDate startDate,
                                             @Param("endDate") LocalDate endDate);

 }
