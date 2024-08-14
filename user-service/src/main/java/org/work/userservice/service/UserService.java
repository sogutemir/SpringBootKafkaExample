package org.work.userservice.service;

import org.work.userservice.dto.UserDto;
import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
    UserDto getUserById(Long id);
    UserDto createUser(UserDto userDto);
    void deleteUser(Long id);
}
