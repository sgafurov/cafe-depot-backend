package com.cafe_depot.cafe_depot.controllers;

import org.slf4j.LoggerFactory;

import javax.validation.Valid;

import org.slf4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cafe_depot.cafe_depot.command.CreateUser;
import com.cafe_depot.cafe_depot.command.LogInUser;
import com.cafe_depot.cafe_depot.models.UserModel;
import com.cafe_depot.cafe_depot.services.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:10533", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    // @Autowired
    // private AuthenticationManager authenticationManager;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/sign-up") // post request made to baseUrl/api/users/sign-up
    public ResponseEntity<UserModel> createUser(@RequestBody @Valid CreateUser userCommand) {
        logger.info("createUser request recieved with username: " + userCommand);
        UserModel userModel = userService.createUser(userCommand); // use Service to implement business logic
        logger.info("successfully created new user with id: " + userModel.getId());
        return new ResponseEntity<>(userModel, HttpStatus.OK);
    }

    // @PostMapping("/log-in")
    // public ResponseEntity<UserModel> logInUser(@RequestBody LogInUser userCommand) {
    //     logger.info("logInUser request recieved with username: " + userCommand);
    //     UserModel userModel = userService.logInUser(userCommand); // use service to validate
    //     return new ResponseEntity<>(userModel, HttpStatus.OK);
    // }

    @GetMapping("/{email}")
    public ResponseEntity<UserModel> getUserByEmail(@PathVariable String email) {
        logger.info("getUserByEmail request recieved with email: " + email);
        return new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.OK);
        // .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
        // .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // @GetMapping("/get/{username}")
    // public ResponseEntity<UserModel> getUserByUsername(@PathVariable String username) {
    //     logger.info("getUserByUsername request recieved with username: " + username);
    //     return new ResponseEntity<>(userService.getUserByUsername(username), HttpStatus.OK);
    //     // .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
    //     // .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    // }

    // Endpoint to create a new user
    // @PostMapping
    // public ResponseEntity<User> createUser(@RequestBody @Validated UserRequestDto
    // userRequestDto) {
    // User createdUser = userService.createUser(userRequestDto);
    // return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    // }

    // Endpoint to delete a user by ID
    // @DeleteMapping("/delete/{username}")
    // public ResponseEntity<Void> deleteUser(@PathVariable String username) {
    //     userService.deleteByUsername(username);
    //     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // }
}
