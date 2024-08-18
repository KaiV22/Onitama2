package com.example.onitama2.services;

import com.example.onitama2.api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final List<User> userList;

    public UserService() {
        this.userList = new ArrayList<>();
    }

    public Optional<User> addNewUser(String userName) {
        for (User user : userList) {
            if (user.getUserName().equals(userName)) {
                return Optional.empty();
            }
        }
        User newUser = new User(userName);
        userList.add(newUser);
        return Optional.of(newUser);
    }
}
