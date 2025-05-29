package com.sangura.ruralconnect.notificationService.dto;

import com.sangura.ruralconnect.notificationService.entities.enums.NotificationType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class NotificationDto {

    private Long customerId;

    private String messageInfo;

    private LocalDateTime createdAt;

    @Enumerated(value = EnumType.STRING)
    private NotificationType notificationType;
}
