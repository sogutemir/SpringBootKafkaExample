package org.work.notificationservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.work.notificationservice.model.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
}