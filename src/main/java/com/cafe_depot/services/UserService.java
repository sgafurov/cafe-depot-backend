package com.cafe_depot.services;

import com.cafe_depot.entities.User;
import com.cafe_depot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User createUser(User user) {
        // Check if the username is already taken
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }

        return userRepository.save(user);
    }

    // public User updateUser(String username, User updatedUser) {
    //     return userRepository.findByUsername(username)
    //             .map(user -> {
    //                 user.setUsername(updatedUser.getUsername());
    //                 user.setPassword(hashPassword(updatedUser.getPassword()));
    //                 user.setEmail(updatedUser.getEmail());
    //                 user.setAddress(updatedUser.getAddress());
    //                 return userRepository.save(user);
    //             })
    //             .orElse(null);
    // }

    public void deleteByUsername(String username) {
        userRepository.deleteByUsername(username);
    }
}
