package com.cafe_depot.cafe_depot.mapper;

import org.springframework.stereotype.Component;

import com.cafe_depot.cafe_depot.command.CreateUser;
import com.cafe_depot.cafe_depot.entities.User;
import com.cafe_depot.cafe_depot.models.UserModel;

@Component
public class UserMapper {
    public UserModel toModel(User user) {
        return new UserModel(user.getId(), user.getUsername(), user.getEmail(), user.getAddress());
    }

    public User toEntity(CreateUser userCommand) {
        return new User(userCommand.getUsername(), userCommand.getPassword(), userCommand.getEmail(),
                userCommand.getAddress());
    }
}