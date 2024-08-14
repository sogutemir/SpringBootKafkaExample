package org.work.notificationservice.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.work.notificationservice.model.Notification}
 */
@Value
public class NotificationDto implements Serializable {
    Long id;
    Long userId;
    String message;
}