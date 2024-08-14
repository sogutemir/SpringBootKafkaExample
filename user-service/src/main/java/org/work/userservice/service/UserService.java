package org.work.userservice.service;

import org.work.userservice.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User createUser(User userDto);
    void deleteUser(Long id);
}
