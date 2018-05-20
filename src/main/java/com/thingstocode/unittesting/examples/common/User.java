package com.thingstocode.unittesting.examples.common;

import lombok.Getter;

public class User {
    @Getter
    private String username;
    @Getter
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
