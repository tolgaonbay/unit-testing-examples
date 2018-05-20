package com.thingstocode.unittesting.examples.example3;

import com.thingstocode.unittesting.examples.common.*;

public class AuditableUserAuthenticator implements Authenticator {
    private static final String UNKNOWN_USER_ERROR_CODE = "UNKNOWN-USER";

    private UserRepository userRepository;
    private AuditLogger auditLogger;

    public AuditableUserAuthenticator(UserRepository userRepository, AuditLogger auditLogger) {
        this.userRepository = userRepository;
        this.auditLogger = auditLogger;
    }

    public boolean authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            auditLogger.log(username, UNKNOWN_USER_ERROR_CODE);

            throw new UnknownUserException();
        }

        return user.getPassword().equals(password);
    }
}
