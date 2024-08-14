package org.work.notificationservice.mapper;

import org.mapstruct.*;
import org.work.notificationservice.dto.NotificationDto;
import org.work.notificationservice.model.Notification;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface NotificationMapper {
    Notification toEntity(NotificationDto notificationDto);

    NotificationDto toDto(Notification notification);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Notification partialUpdate(NotificationDto notificationDto, @MappingTarget Notification notification);
}