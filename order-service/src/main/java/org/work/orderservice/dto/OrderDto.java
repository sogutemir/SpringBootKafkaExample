package org.work.orderservice.dto;

import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link org.work.orderservice.model.Order}
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDto implements Serializable {
    Long id;
    Long userId;
    String item;
    int quantity;
}