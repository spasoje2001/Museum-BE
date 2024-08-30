package com.veljko121.backend.dto;

import com.veljko121.backend.core.enums.NotificationType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotificationResponseDTO {
    private Integer id;
    private String message;
    private NotificationType type;  // Assuming NotificationType is an enum
    private LocalDateTime timestamp;
    private boolean isRead;
    private String actionUrl;  // URL za akciju koja je povezana sa notifikacijom
}
