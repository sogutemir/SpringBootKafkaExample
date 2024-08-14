package org.work.notificationservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.work.notificationservice.dto.NotificationDto;
import org.work.notificationservice.mapper.NotificationMapper;
import org.work.notificationservice.model.Notification;
import org.work.notificationservice.repository.NotificationRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    private static final String LOG_TOPIC = "log_topic";
    private static final String ORDER_TOPIC = "order_topic";

    @Override
    public List<NotificationDto> getAllNotifications() {
        return notificationRepository.findAll().stream()
                .map(notificationMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public NotificationDto getNotificationById(Long id) {
        return notificationRepository.findById(id)
                .map(notificationMapper::toDto)
                .orElse(null);
    }

    @Override
    public NotificationDto createNotification(NotificationDto notificationDto) {
        Notification notification = notificationMapper.toEntity(notificationDto);
        Notification savedNotification = notificationRepository.save(notification);
        kafkaTemplate.send(LOG_TOPIC, "Notification created: " + savedNotification.toString());
        return notificationMapper.toDto(savedNotification);
    }

    @Override
    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);
        kafkaTemplate.send(LOG_TOPIC, "Notification deleted: " + id);
    }

    @KafkaListener(topics = ORDER_TOPIC, groupId = "notification_group")
    public void listenToOrderTopic(String message) {
        System.out.println("Received message: " + message);
        Notification notification = new Notification();
        notification.setUserId(1L); // Example userId, adjust as needed
        notification.setMessage(message);
        Notification savedNotification = notificationRepository.save(notification);
        kafkaTemplate.send(LOG_TOPIC, "Notification created from order: " + savedNotification.toString());
    }
}
