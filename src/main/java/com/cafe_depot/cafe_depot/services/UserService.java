package com.cafe_depot.cafe_depot.services;

import com.cafe_depot.cafe_depot.command.CreateUser;
import com.cafe_depot.cafe_depot.command.LogInUser;
import com.cafe_depot.cafe_depot.entities.UserEntity;
import com.cafe_depot.cafe_depot.entities.UserSessionEntity;
import com.cafe_depot.cafe_depot.mapper.UserMapper;
import com.cafe_depot.cafe_depot.models.UserModel;
import com.cafe_depot.cafe_depot.repositories.UserRepository;
import com.cafe_depot.cafe_depot.repositories.UserSessionRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final UserSessionRepository userSessionRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper,
            UserSessionRepository userSessionRepository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.userSessionRepository = userSessionRepository;
    }

    public UserModel createUser(CreateUser userCommand) {
        // useRepo talks with the db to check if the username is already taken
        if (userRepository.findByEmail(userCommand.getEmail()).isPresent()) {
            throw new IllegalArgumentException("User with this email already exists.");
        }
        UserEntity userEntity = userMapper.toEntity(userCommand);
        UserEntity newUser = userRepository.save(userEntity); // saves to the db
        UserModel userModel = userMapper.toModel(newUser); // creates a new model to return to client
        return userModel;
    }

    // public UserModel logInUser(LogInUser userCommand) {
    // logger.info("logInUser service called");
    // // Optional<User> userOption =
    // // userRepository.findByUsernameAndPassword(userCommand.getUsername(),
    // // hashedPassword);
    // Optional<UserEntity> userOption =
    // userRepository.findByUsername(userCommand.getUsername());

    // if (userOption.isPresent()) {
    // UserEntity userEntity = userOption.get();
    // if (userMapper.verifyPassword(userCommand.getPassword(),
    // userEntity.getPassword())) {
    // // creating token after veryifing password
    // UserSessionEntity userSessionEntity = new
    // UserSessionEntity(UUID.randomUUID().toString(), userEntity);
    // // save token to its session db
    // userSessionEntity = userSessionRepository.save(userSessionEntity);
    // // make a user model dto with its session id
    // UserModel userModel = userMapper.toModel(userEntity, userSessionEntity); //
    // creates a new model to return to client
    // return userModel;
    // }
    // // TODO update DB with login attempts
    // }
    // throw new IllegalArgumentException("Invalid login.");
    // }

    public UserModel getUserByEmail(String email) {
        Optional<UserEntity> userEntityOptional = userRepository.findByEmail(email);

        if (userEntityOptional.isPresent()) {
            UserEntity userEntity = userEntityOptional.get();
            return userMapper.toModel(userEntity); // dont return entity directly
        } else {
            throw new IllegalArgumentException("User not found");
        }
    }

    // public UserModel getUserByUsername(String username) {
    // Optional<UserEntity> userEntityOptional =
    // userRepository.findByUsername(username);

    // if (userEntityOptional.isPresent()) {
    // UserEntity userEntity = userEntityOptional.get();
    // return userMapper.toModel(userEntity);
    // } else {
    // throw new IllegalArgumentException("User not found");
    // }
    // // return userRepository.findByUsername(username)
    // // .map(user -> userMapper.toModel(user))
    // // .orElseThrow(() -> new IllegalArgumentException("User not found"));

    // // Dont return entity directly...return
    // userRepository.findByUsername(username)
    // }

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

    // public void deleteByUsername(String username) {
    //     userRepository.deleteByUsername(username);
    // }
}
