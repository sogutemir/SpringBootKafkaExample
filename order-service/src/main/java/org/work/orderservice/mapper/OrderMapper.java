package org.work.orderservice.mapper;

import org.mapstruct.*;
import org.work.orderservice.dto.OrderDto;
import org.work.orderservice.model.Order;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)public interface OrderMapper {
    Order toEntity(OrderDto orderDto);

    OrderDto toDto(Order order);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)Order partialUpdate(OrderDto orderDto, @MappingTarget Order order);
}