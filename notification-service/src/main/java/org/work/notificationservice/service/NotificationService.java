package org.work.notificationservice.service;

import org.work.notificationservice.model.Notification;

import java.util.List;

public interface NotificationService {
    List<Notification> getAllNotifications();
    Notification getNotificationById(Long id);
    Notification createNotification(Notification notification);
    void deleteNotification(Long id);
}
