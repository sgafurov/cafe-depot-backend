package com.cafe_depot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cafe_depot.entities.User;
import com.cafe_depot.services.UserService;


@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        userService.createUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    
    @GetMapping("/get/{username}")
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

    // Endpoint to delete a user by ID
    @DeleteMapping("/delete/{username}")
    public ResponseEntity<Void> deleteUser(@PathVariable String username) {
        userService.deleteByUsername(username);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
