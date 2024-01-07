package com.cafe_depot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.cafe_depot.entities.User;
import com.cafe_depot.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Endpoint to retrieve a user by ID
    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username)
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint to create a new user
    // @PostMapping
    // public ResponseEntity<User> createUser(@RequestBody @Validated UserRequestDto
    // userRequestDto) {
    // User createdUser = userService.createUser(userRequestDto);
    // return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    // }

    @PostMapping("/sign-up")
    public String signUp(@RequestBody User user) {
        userService.createUser(user.getUsername(), user.getPassword(), user.getEmail(), user.getAddress());

        return "User created successfully";
    }

    // Endpoint to delete a user by ID
    @DeleteMapping("/{username}")
    public ResponseEntity<Void> deleteUser(@PathVariable String username) {
        userService.deleteByUsername(username);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
