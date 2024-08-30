package com.veljko121.backend.service.impl;

import com.veljko121.backend.core.enums.NotificationType;
import com.veljko121.backend.core.service.impl.CRUDService;
import com.veljko121.backend.model.*;
import com.veljko121.backend.repository.ItemRepository;
import com.veljko121.backend.repository.NotificationRepository;
import com.veljko121.backend.repository.RoomRepository;
import com.veljko121.backend.service.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService extends CRUDService<Notification, Integer> implements INotificationService {
    private final NotificationRepository notificationRepository;
    @Autowired
    private IGuestService guestService;
    @Autowired
    private IExhibitionService exhibitionService;
    @Autowired
    private ITicketService ticketService;
    @Autowired
    private IReviewService reviewService;
    @Autowired
    public NotificationService(NotificationRepository repository) {
        super(repository);
        notificationRepository = repository;
    }

    @Override
    @Transactional
    public void notifyExhibitionUpdate(Integer exhibitionId) {
        Exhibition exhibition = exhibitionService.findById(exhibitionId);
        String message = "The exhibition '" + exhibition.getName() + "' has been updated.";
        NotificationType type = NotificationType.EXHIBITION;
        String url = "/exhibitions/" + exhibitionId;

        List<Guest> guests = guestService.findUsersWithTicketsForExhibition(exhibition);
        sendNotifications(guests, message, type, url);
    }

    @Override
    @Transactional
    public void notifyNewExhibition(Integer exhibitionId) {
        Exhibition exhibition = exhibitionService.findById(exhibitionId);
        String message = "A new exhibition '" + exhibition.getName() + "' has been announced.";
        NotificationType type = NotificationType.EXHIBITION;
        String url = "/exhibitions/" + exhibitionId;

        List<Guest> guests = guestService.findUsersInterestedInTheme(exhibition.getTheme());
        sendNotifications(guests, message, type, url);
    }

    @Override
    @Transactional
    public void sendReminderForExhibition(Integer exhibitionId) {
        Exhibition exhibition = exhibitionService.findById(exhibitionId);
        String message = "Reminder: The exhibition '" + exhibition.getName() + "' is opening soon!";
        NotificationType type = NotificationType.EXHIBITION;
        String url = "/exhibitions/" + exhibitionId;

        List<Guest> guests = guestService.findUsersWithTicketsForExhibition(exhibition);
        sendNotifications(guests, message, type, url);
    }

    @Override
    @Transactional
    public void notifyPurchaseConfirmation(Integer ticketId) {
        Ticket ticket = ticketService.findById(ticketId);
        String message = "Your purchase for the exhibition '" + ticket.getExhibition().getName() + "' has been confirmed.";
        NotificationType type = NotificationType.PURCHASE;
        String url = "/profile";

        Guest guest = ticket.getGuest();
        sendNotification(guest, message, type, url);
    }

    @Override
    @Transactional
    public void notifyNewReview(Integer reviewId) {
        Review review = reviewService.findById(reviewId);
        String message = "A new review has been posted on the exhibition '" + review.getExhibition().getName() + "'.";
        NotificationType type = NotificationType.REVIEW;
        String url = "/exhibitions/" + review.getExhibition().getId();

        List<Guest> guests = guestService.findUsersWhoReviewedExhibition(review.getExhibition());
        sendNotifications(guests, message, type, url);
    }

    @Override
    @Transactional
    public void notifyPromotion(Integer exhibitionId) {
        Exhibition exhibition = exhibitionService.findById(exhibitionId);
        String message = "Good news! The price for the exhibition '" + exhibition.getName() + "' has been reduced.";
        NotificationType type = NotificationType.PROMOTION;
        String url = "/exhibitions/" + exhibitionId;

        List<Guest> guests = guestService.findUsersWithoutTicketsForExhibition(exhibition);
        sendNotifications(guests, message, type, url);
    }

    @Override
    @Transactional
    public void notifyExhibitionClosingSoon(Integer exhibitionId) {
        Exhibition exhibition = exhibitionService.findById(exhibitionId);
        String message = "The exhibition '" + exhibition.getName() + "' is closing soon. Don't miss it!";
        NotificationType type = NotificationType.REMINDER;
        String url = "/exhibitions/" + exhibitionId;

        List<Guest> guests = guestService.findUsersWithTicketsForExhibition(exhibition);
        sendNotifications(guests, message, type, url);
    }

    @Override
    @Transactional
    public List<Notification> getAllNotificationsByUserId(Integer userId) {
        return notificationRepository.findAllByUserId(userId);
    }

    @Override
    @Transactional
    public void markAsRead(Integer notificationId) {
        Notification notification = findById(notificationId);
        if (notification != null && !notification.isRead()) {
            notification.setRead(true);
            notificationRepository.save(notification);
        }
    }


    private void sendNotifications(List<Guest> guests, String message, NotificationType type, String actionUrl) {
        if (guests == null || guests.isEmpty()) {
            return;
        }
        guests.forEach(guest -> sendNotification(guest, message, type, actionUrl));
    }

    private void sendNotification(Guest guest, String message, NotificationType type, String actionUrl) {
        Notification notification = new Notification(guest, message, type, actionUrl);
        notificationRepository.save(notification);
    }

}
