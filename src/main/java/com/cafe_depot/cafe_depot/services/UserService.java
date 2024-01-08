package com.cafe_depot.cafe_depot.services;

import com.cafe_depot.cafe_depot.command.CreateUser;
import com.cafe_depot.cafe_depot.entities.User;
import com.cafe_depot.cafe_depot.mapper.UserMapper;
import com.cafe_depot.cafe_depot.models.UserModel;
import com.cafe_depot.cafe_depot.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserModel createUser(CreateUser userCommand) {
        // useRepo talks with the db to check if the username is already taken
        if (userRepository.findByUsername(userCommand.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username already exists. Choose another username.");
        }
        User userEntity = userMapper.toEntity(userCommand);
        User newUser = userRepository.save(userEntity); // saves to the db
        UserModel userModel = userMapper.toModel(newUser); // creates a new model to return to client
        return userModel;
    }

    public UserModel getUserByUsername(String username) {
        Optional<User> userEntityOptional = userRepository.findByUsername(username);

        if (userEntityOptional.isPresent()) {
            User userEntity = userEntityOptional.get();
            return userMapper.toModel(userEntity);
        } else {
            throw new IllegalArgumentException("User not found");
        }
        // return userRepository.findByUsername(username)
        // .map(user -> userMapper.toModel(user))
        // .orElseThrow(() -> new IllegalArgumentException("User not found"));

        // Dont return entity directly...return userRepository.findByUsername(username)
    }

    // public User updateUser(String username, User updatedUser) {
    // return userRepository.findByUsername(username)
    // .map(user -> {
    // user.setUsername(updatedUser.getUsername());
    // user.setPassword(hashPassword(updatedUser.getPassword()));
    // user.setEmail(updatedUser.getEmail());
    // user.setAddress(updatedUser.getAddress());
    // return userRepository.save(user);
    // })
    // .orElse(null);
    // }

    public void deleteByUsername(String username) {
        userRepository.deleteByUsername(username);
    }
}
