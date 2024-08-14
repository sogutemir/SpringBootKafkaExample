package org.work.notificationservice.service;

import org.work.notificationservice.dto.NotificationDto;

import java.util.List;

public interface NotificationService {

    List<NotificationDto> getAllNotifications();
    NotificationDto getNotificationById(Long id);
    NotificationDto createNotification(NotificationDto notificationDto);
    void deleteNotification(Long id);

}
