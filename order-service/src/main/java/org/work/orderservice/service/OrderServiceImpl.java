package org.work.orderservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.work.orderservice.dto.OrderDto;
import org.work.orderservice.mapper.OrderMapper;
import org.work.orderservice.model.Order;
import org.work.orderservice.repository.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    private static final String ORDER_TOPIC = "order_topic";
    private static final String LOG_TOPIC = "log_topic";

    @Override
    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto getOrderById(Long id) {
        return orderRepository.findById(id)
                .map(orderMapper::toDto)
                .orElse(null);
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        Order order = orderMapper.toEntity(orderDto);
        Order savedOrder = orderRepository.save(order);
        kafkaTemplate.send(ORDER_TOPIC, "Order created: " + savedOrder.toString());
        kafkaTemplate.send(LOG_TOPIC, "Order created: " + savedOrder.toString());
        return orderMapper.toDto(savedOrder);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
        kafkaTemplate.send(LOG_TOPIC, "Order deleted: " + id);
    }
}
