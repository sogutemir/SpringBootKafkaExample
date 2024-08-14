package org.work.orderservice.service;

import org.work.orderservice.dto.OrderDto;

import java.util.List;

public interface OrderService {
    List<OrderDto> getAllOrders();
    OrderDto getOrderById(Long id);
    OrderDto createOrder(OrderDto orderDto);
    void deleteOrder(Long id);
}
