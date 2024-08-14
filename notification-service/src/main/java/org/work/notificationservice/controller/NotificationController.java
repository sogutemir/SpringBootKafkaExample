package org.work.notificationservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.work.notificationservice.model.Notification;
import org.work.notificationservice.service.NotificationService;

import java.util.List;


@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping
    public List<Notification> getAllNotifications() {
        return notificationService.getAllNotifications();
    }

    @GetMapping("/{id}")
    public Notification getNotificationById(@PathVariable Long id) {
        return notificationService.getNotificationById(id);
    }

    @PostMapping
    public Notification createNotification(@RequestBody Notification notification) {
        return notificationService.createNotification(notification);
    }

    @DeleteMapping("/{id}")
    public void deleteNotification(@PathVariable Long id) {
        notificationService.deleteNotification(id);
    }
}