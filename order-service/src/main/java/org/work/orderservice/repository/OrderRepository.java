package org.work.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.work.orderservice.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}