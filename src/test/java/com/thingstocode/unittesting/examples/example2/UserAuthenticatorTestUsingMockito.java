package com.thingstocode.unittesting.examples.example2;

import com.thingstocode.unittesting.examples.common.UnknownUserException;
import com.thingstocode.unittesting.examples.common.User;
import com.thingstocode.unittesting.examples.common.UserRepository;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserAuthenticatorTestUsingMockito {

    @Test
    public void shouldReturnTrue_whenUserAuthInfoIsOK() {
        UserRepository userRepository = mock(UserRepository.class);
        UserAuthenticator authenticator = new UserAuthenticator(userRepository);
        when(userRepository.findByUsername(USERNAME)).thenReturn(USER);

        boolean result = authenticator.authenticate(USERNAME, PASSWORD);

        assertThat(result).isTrue();
    }

    @Test
    public void shouldReturnFalse_whenUserAuthInfoIsNotOK() {
        UserRepository userRepository = mock(UserRepository.class);
        UserAuthenticator authenticator = new UserAuthenticator(userRepository);
        when(userRepository.findByUsername(USERNAME)).thenReturn(USER);

        boolean result = authenticator.authenticate(USERNAME, WRONG_PASSWORD);

        assertThat(result).isFalse();
    }

    @Test
    public void shouldThrowUnknownUserException_whenUserIsUnknown() {
        UserRepository userRepository = mock(UserRepository.class);
        UserAuthenticator authenticator = new UserAuthenticator(userRepository);
        when(userRepository.findByUsername(USERNAME)).thenReturn(NULL_USER);

        assertThatExceptionOfType(UnknownUserException.class).isThrownBy(() -> {
            authenticator.authenticate(USERNAME, PASSWORD);
        });
    }

    private static final String USERNAME = "user1";
    private static final String PASSWORD = "pass1";

    private static final String WRONG_PASSWORD = "wrong-password";

    private static final User USER = new User(USERNAME, PASSWORD);
    private static final User NULL_USER = null;
}

