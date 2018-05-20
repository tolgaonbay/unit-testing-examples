package com.thingstocode.unittesting.examples.example2;

import com.thingstocode.unittesting.examples.common.Authenticator;
import com.thingstocode.unittesting.examples.common.UnknownUserException;
import com.thingstocode.unittesting.examples.common.User;
import com.thingstocode.unittesting.examples.common.UserRepository;

public class UserAuthenticator implements Authenticator {
    private UserRepository userRepository;

    public UserAuthenticator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UnknownUserException();
        }

        return user.getPassword().equals(password);
    }
}
