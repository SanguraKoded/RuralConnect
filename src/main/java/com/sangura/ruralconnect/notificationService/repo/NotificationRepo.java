package com.sangura.ruralconnect.notificationService.repo;

import com.sangura.ruralconnect.notificationService.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepo extends JpaRepository<Notification, Long> {
    List<Notification> findNotificationByCustomerId(Long id);
}
