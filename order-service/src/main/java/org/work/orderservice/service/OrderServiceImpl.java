package org.work.orderservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.work.orderservice.model.Order;
import org.work.orderservice.repository.OrderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;

    private static final String ORDER_TOPIC = "order_topic";
    private static final String LOG_TOPIC = "log_topic";

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order createOrder(Order order) {
        Order savedOrder = orderRepository.save(order);
        kafkaTemplate.send(ORDER_TOPIC, "Order created: " + savedOrder.toString());
        kafkaTemplate.send(LOG_TOPIC, "Order created: " + savedOrder.toString());
        return savedOrder;
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
        kafkaTemplate.send(LOG_TOPIC, "Order deleted: " + id);
    }
}