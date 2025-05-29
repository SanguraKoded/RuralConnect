package com.sangura.ruralconnect.notificationService.services;

import com.sangura.ruralconnect.notificationService.dto.NotificationDto;
import com.sangura.ruralconnect.notificationService.entities.Notification;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

public interface NotificationService {

    Notification createNotification(NotificationDto notificationDto);

    Notification updateNotification(Long id, NotificationDto notificationDto);

    String deleteNotification(Long id);

    List<Notification> getNotificationsByCustomer(Long id);

    List<Notification> getAllNotifications();

    TreeMap<LocalDateTime,List<NotificationDto>> getNotificationsByDate();


}
