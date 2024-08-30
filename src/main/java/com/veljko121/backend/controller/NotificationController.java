package com.veljko121.backend.controller;

import com.veljko121.backend.dto.NotificationResponseDTO;
import com.veljko121.backend.mapper.ExhibitionMapper;
import com.veljko121.backend.mapper.NotificationMapper;
import com.veljko121.backend.model.Exhibition;
import com.veljko121.backend.model.Review;
import com.veljko121.backend.model.Ticket;
import com.veljko121.backend.service.IExhibitionService;
import com.veljko121.backend.service.INotificationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final INotificationService notificationService;
    private final ModelMapper modelMapper;
    private final NotificationMapper notificationMapper;

    @PostMapping("/exhibition-update/{exhibitionId}")
    public ResponseEntity<Void> notifyExhibitionUpdate(@PathVariable Integer exhibitionId) {
        notificationService.notifyExhibitionUpdate(exhibitionId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/new-exhibition/{exhibitionId}")
    public ResponseEntity<Void> notifyNewExhibition(@PathVariable Integer exhibitionId) {
        notificationService.notifyNewExhibition(exhibitionId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/exhibition-reminder/{exhibitionId}")
    public ResponseEntity<Void> sendReminderForExhibition(@PathVariable Integer exhibitionId) {
        notificationService.sendReminderForExhibition(exhibitionId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/purchase-confirmation/{ticketId}")
    public ResponseEntity<Void> notifyPurchaseConfirmation(@PathVariable Integer ticketId) {
        notificationService.notifyPurchaseConfirmation(ticketId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/new-review/{reviewId}")
    public ResponseEntity<Void> notifyNewReview(@PathVariable Integer reviewId) {
        notificationService.notifyNewReview(reviewId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/promotion/{exhibitionId}")
    public ResponseEntity<Void> notifyPromotion(@PathVariable Integer exhibitionId) {
        notificationService.notifyPromotion(exhibitionId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/exhibition-closing-soon/{exhibitionId}")
    public ResponseEntity<Void> notifyExhibitionClosingSoon(@PathVariable Integer exhibitionId) {
        notificationService.notifyExhibitionClosingSoon(exhibitionId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<NotificationResponseDTO>> getUserNotifications(@PathVariable Integer userId) {
        var notifications = notificationService.getAllNotificationsByUserId(userId);
        var notificationDTOs = notifications.stream()
                .map(notificationMapper::mapToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(notificationDTOs);
    }

    @PostMapping("/read/{notificationId}")
    public ResponseEntity<Void> markNotificationAsRead(@PathVariable Integer notificationId) {
        notificationService.markAsRead(notificationId);
        return ResponseEntity.ok().build();
    }

}
