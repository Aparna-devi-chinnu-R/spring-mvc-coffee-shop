package com.mvc.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserValidationServiceTest {

    @Autowired
    private UserValidationService userValidationService;

    @Test
    void shouldValidateUserAndPassword() {
        boolean isValid = userValidationService.validateUserAndPassword("DummyUser", "DummyPassword");

        assertTrue(isValid);
    }
}
