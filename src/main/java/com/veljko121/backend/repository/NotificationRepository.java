package com.veljko121.backend.repository;

import com.veljko121.backend.model.Guest;
import com.veljko121.backend.model.ItemReservation;
import com.veljko121.backend.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    List<Notification> findAllByUserId(Integer userId);
}
