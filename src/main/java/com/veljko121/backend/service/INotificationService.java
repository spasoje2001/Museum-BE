package com.veljko121.backend.service;

import com.veljko121.backend.core.service.ICRUDService;
import com.veljko121.backend.model.*;

import java.util.List;

public interface INotificationService extends ICRUDService<Notification, Integer> {
    void notifyExhibitionUpdate(Integer exhibitionId);
    void notifyNewExhibition(Integer exhibitionId);
    void sendReminderForExhibition(Integer exhibitionId);
    void notifyPurchaseConfirmation(Integer ticketId);
    void notifyNewReview(Integer reviewId);
    void notifyPromotion(Integer exhibitionId);
    void notifyExhibitionClosingSoon(Integer exhibitionId);
    List<Notification> getAllNotificationsByUserId(Integer userId);

    void markAsRead(Integer notificationId);


}
