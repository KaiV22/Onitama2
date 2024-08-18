package com.example.onitama2.api.model;

import java.util.UUID;

public class User {
    private UUID id;
    private String userName;

    public User(String userName) {
        setUserName(userName);
        setId(UUID.randomUUID());
    }

    public void setId(UUID id) {
        this.id = id;
    }

    private void setUserName(String userName) {
        this.userName = userName;
    }

    public UUID getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }
}
