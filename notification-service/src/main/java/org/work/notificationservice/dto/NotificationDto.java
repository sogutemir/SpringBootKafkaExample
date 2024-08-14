package org.work.notificationservice.dto;

import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link org.work.notificationservice.model.Notification}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDto implements Serializable {
    Long id;
    Long userId;
    String message;
}