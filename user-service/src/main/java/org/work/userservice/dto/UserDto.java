package org.work.userservice.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.work.userservice.model.User}
 */
@Value
public class UserDto implements Serializable {
    Long id;
    String name;
    String email;
}