package org.work.orderservice.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.work.orderservice.model.Order}
 */
@Value
public class OrderDto implements Serializable {
    Long id;
    Long userId;
    String item;
    int quantity;
}