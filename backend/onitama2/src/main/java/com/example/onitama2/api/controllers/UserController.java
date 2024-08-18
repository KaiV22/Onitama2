package com.example.onitama2.api.controllers;

import com.example.onitama2.api.model.User;
import com.example.onitama2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/auth/join")
    public User authenticate(@RequestParam String userName) {
        Optional<User> userOptional = userService.addNewUser(userName);
        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already in use");
        }
    }
}
