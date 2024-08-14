package org.work.userservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.work.userservice.model.User;
import org.work.userservice.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(userRepository.findAll());
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
