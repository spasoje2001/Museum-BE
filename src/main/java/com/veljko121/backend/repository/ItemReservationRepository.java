package com.veljko121.backend.repository;

import com.veljko121.backend.model.ItemReservation;
import com.veljko121.backend.model.RoomReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemReservationRepository extends JpaRepository<ItemReservation, Integer> {
}
