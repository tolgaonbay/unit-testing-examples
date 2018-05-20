package com.thingstocode.unittesting.examples.example2;

import com.thingstocode.unittesting.examples.common.User;
import com.thingstocode.unittesting.examples.common.UserRepository;
import org.junit.Test;

import static com.thingstocode.unittesting.examples.example2.UserAuthenticatorTest.UserRepositoryStub.aUserRepositoryStub;
import static org.assertj.core.api.Assertions.assertThat;

public class UserAuthenticatorTest {

    @Test
    public void shouldReturnTrue_whenUserAuthInfoIsOK() {
        UserRepository repository = aUserRepositoryStub().thatReturnsUserWhenFindByUsernameCalled(USER);
        UserAuthenticator authenticator = new UserAuthenticator(repository);

        boolean result = authenticator.authenticate(USERNAME, PASSWORD);

        assertThat(result).isTrue();
    }

    public static class UserRepositoryStub implements UserRepository {
        private User user;

        public static UserRepositoryStub aUserRepositoryStub() {
            return new UserRepositoryStub();
        }

        public UserRepositoryStub thatReturnsUserWhenFindByUsernameCalled(User user) {
            this.user = user;

            return this;
        }

        public User findByUsername(String username) {
            return user;
        }
    }

    private static final String USERNAME = "user1";
    private static final String PASSWORD = "pass1";

    private static final User USER = new User(USERNAME, PASSWORD);
}