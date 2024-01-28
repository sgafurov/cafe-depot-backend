package com.cafe_depot.cafe_depot.mapper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.cafe_depot.cafe_depot.command.CreateUser;
import com.cafe_depot.cafe_depot.command.LogInUser;
import com.cafe_depot.cafe_depot.entities.UserEntity;
import com.cafe_depot.cafe_depot.entities.UserSessionEntity;
import com.cafe_depot.cafe_depot.models.UserModel;

@Component
public class UserMapper {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserMapper() {
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    public String hashPassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    public Boolean verifyPassword(String rawPassword, String hashedPassword) {
        return bCryptPasswordEncoder.matches(rawPassword, hashedPassword);
    }

    public UserModel toModel(UserEntity user) {
        return new UserModel(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getAddress(),
                null);
    }

    public UserModel toModel(UserEntity user, UserSessionEntity userSessionEntity) {
        return new UserModel(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getAddress(),
                userSessionEntity.getSessionId());
    }

    public UserEntity toEntity(CreateUser userCommand) {
        return new UserEntity(userCommand.getFirstName(), userCommand.getLastName(), userCommand.getEmail(),
                hashPassword(userCommand.getPassword()), userCommand.getAddress());
    }

    // public UserEntity toEntity(LogInUser userCommand) {
    //     return new UserEntity(userCommand.getUsername(), userCommand.getPassword(), null, null);
    // }
}