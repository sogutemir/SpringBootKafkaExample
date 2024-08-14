package org.work.userservice.dto;

import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link org.work.userservice.model.User}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    Long id;
    String name;
    String email;
}