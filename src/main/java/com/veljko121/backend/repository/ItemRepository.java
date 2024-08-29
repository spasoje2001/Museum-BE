package com.veljko121.backend.repository;

import com.veljko121.backend.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import com.veljko121.backend.model.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer>{

    @Query("""
            SELECT i\s
            FROM Item i\s
            WHERE UPPER(i.name) LIKE UPPER(?1) OR UPPER(i.name) LIKE (UPPER('%' || ?1 || '%'))""")
    List<Item> findByName(String name);

    @Query("SELECT i FROM Item i WHERE i.id NOT IN " +
            "(SELECT ir.item.id FROM ItemReservation ir WHERE " +
            "(ir.startDate <= :endDate AND ir.endDate >= :startDate))")
    List<Item> findAvailableItems(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT i FROM Item i WHERE i.id NOT IN " +
            "(SELECT ir.item.id FROM ItemReservation ir WHERE " +
            "(ir.startDate <= :endDate AND ir.endDate >= :startDate) " +
            "AND ir.exhibition.id <> :exhibitionId)")
    List<Item> findAvailableItemsForUpdate(@Param("startDate") LocalDate startDate,
                                           @Param("endDate") LocalDate endDate,
                                           @Param("exhibitionId") Integer exhibitionId);


}
