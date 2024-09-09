package com.veljko121.backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.veljko121.backend.model.Room;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;


public interface RoomRepository extends JpaRepository<Room, Integer>{
    @Query("SELECT r FROM Room r WHERE r.id NOT IN " +
            "(SELECT rr.room.id FROM RoomReservation rr WHERE " +
            "(rr.startDate <= :endDate AND rr.endDate >= :startDate))")
    List<Room> findAvailableRooms(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);


    @Query("SELECT r FROM Room r WHERE r.id NOT IN " +
            "(SELECT rr.room.id FROM RoomReservation rr WHERE " +
            "(rr.startDate <= :endDate AND rr.endDate >= :startDate) " +
            "AND rr.exhibitionProposal.id <> :proposalId)")
    List<Room> findAvailableRoomsForUpdate(@Param("startDate") LocalDate startDate,
                                           @Param("endDate") LocalDate endDate,
                                           @Param("proposalId") Integer proposalId);

    @Query("SELECT r FROM Room r WHERE r.id NOT IN " +
            "(SELECT rr.room.id FROM RoomReservation rr WHERE rr.exhibitionProposal IN " +
            "(SELECT e.exhibitionProposal FROM Exhibition e WHERE e.status IN (com.veljko121.backend.core.enums.ExhibitionStatus.OPENED, com.veljko121.backend.core.enums.ExhibitionStatus.READY_TO_OPEN)))")
    List<Room> findRoomsNotReservedForOpenExhibitions();

}
