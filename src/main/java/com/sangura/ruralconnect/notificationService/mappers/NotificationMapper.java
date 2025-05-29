package com.sangura.ruralconnect.notificationService.mappers;

import com.sangura.ruralconnect.notificationService.dto.NotificationDto;
import com.sangura.ruralconnect.notificationService.entities.Notification;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public interface  NotificationMapper {

    default Notification toEntity(NotificationDto notificationDto){

        if(notificationDto==null){
            return null;
        }
        Notification notification = new Notification();
        notification.setCreatedAt(LocalDateTime.now());
        notification.setCustomerId(notificationDto.getCustomerId());
        notification.setNotificationType(notificationDto.getNotificationType());
        notification.setMessageInfo(notificationDto.getMessageInfo());
        return notification;
    };

    default NotificationDto toDto(Notification notification){
        if(notification==null){
            return null;
        }
        NotificationDto notificationDto = new NotificationDto();
        notificationDto.setNotificationType(notification.getNotificationType());
        notificationDto.setCreatedAt(notification.getCreatedAt());
        notificationDto.setMessageInfo(notification.getMessageInfo());
        notificationDto.setCustomerId(notification.getCustomerId());
        return notificationDto;
    };

    @Mapping(target="id", ignore = true)
    @Mapping(target="createdAt", ignore = true)
    Notification updateNotificationFromDto(NotificationDto notificationDto, @MappingTarget Notification notification);
}
