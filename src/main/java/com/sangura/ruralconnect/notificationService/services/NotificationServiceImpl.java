package com.sangura.ruralconnect.notificationService.services;

import com.sangura.ruralconnect.notificationService.dto.NotificationDto;
import com.sangura.ruralconnect.notificationService.entities.Notification;
import com.sangura.ruralconnect.notificationService.mappers.NotificationMapper;
import com.sangura.ruralconnect.notificationService.repo.NotificationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService{

    private final NotificationRepo notificationRepo;
    private final NotificationMapper notificationMapper;

    @Override
    @Transactional
    public Notification createNotification(NotificationDto notificationDto) {
        try{
            Notification notification = notificationMapper.toEntity(notificationDto);
            notification.setCreatedAt(LocalDateTime.now());
            return notificationRepo.save(notification);
        }catch(Exception e){
            throw new RuntimeException("Unexpected Error Occurred "+e.getMessage());
        }
    }

    @Override
    @Transactional
    public Notification updateNotification(Long id, NotificationDto notificationDto) {
        try{
            Notification notification = notificationRepo.findById(id).orElseThrow(() -> new RuntimeException("Please Enter Correct Notification ID"));
            return notificationMapper.updateNotificationFromDto(notificationDto, notification);
        }catch(Exception e){
            throw new RuntimeException("Unexpected Error Occurred"+e.getMessage());
        }
    }

    @Override
    @Transactional
    public String deleteNotification(Long id) {
        notificationRepo.findById(id).orElseThrow(() -> new RuntimeException("Please Enter Correct Notification ID"));
        notificationRepo.deleteById(id);
        return ("Successfully Deleted");
    }

    @Override
    @Transactional(readOnly = true)
    public List<Notification> getNotificationsByCustomer(Long id) {
        try{
            List<Notification> notifications = notificationRepo.findNotificationByCustomerId(id);
            if(notifications.isEmpty() || notifications==null){
                throw new RuntimeException("No Notification Sent Yet");
            }
            return notifications;
        }catch (Exception e){
            throw new RuntimeException("Unexpected Error Occurred");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Notification> getAllNotifications() {
       List<Notification> allNotifications =  notificationRepo.findAll();
       try{
           if(allNotifications==null||allNotifications.isEmpty()){
               throw new RuntimeException("No Notifications Sent Yet");
           }
           return allNotifications;
       }catch(Exception e){
           throw new RuntimeException("Unexpected Error Occurred");
       }
    }

    @Override
    @Transactional(readOnly = true)
    public TreeMap<LocalDateTime,List<NotificationDto>> getNotificationsByDate() {
        try {
            return notificationRepo.findAll().stream().
                    filter(notification -> notification.getCreatedAt() != null).
                    collect(Collectors.groupingBy(Notification::getCreatedAt,
                            () -> new TreeMap<LocalDateTime, List<NotificationDto>>(Comparator.reverseOrder()),
                            Collectors.mapping(notificationMapper::toDto,
                                    Collectors.toList())));
        }catch(Exception e){
            throw new RuntimeException("Unexpected Error Occurred" + e.getMessage());
        }
    }
}
