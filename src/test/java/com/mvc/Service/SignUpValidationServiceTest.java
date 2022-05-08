package com.mvc.Service;

import com.mvc.Exceptions.InvalidPassword;
import com.mvc.Exceptions.InvalidUserName;
import com.mvc.Exceptions.PasswordAndConfirmPasswordNotEqualException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
public class SignUpValidationServiceTest {

    private SignUpValidationService signUpValidationService;

    @BeforeEach
    void setUp() {
        signUpValidationService = new SignUpValidationService();
    }

    @Test
    void shouldValidateWhetherPasswordAndConfirmPasswordAreSame() throws PasswordAndConfirmPasswordNotEqualException {
        boolean isEqual = signUpValidationService.validatePasswordAndConfirmPassword("password123", "password123");

        assertTrue(isEqual);
    }

    @Test
    void shouldThroughExceptionIfPasswordAndConfirmPasswordAreNotSame() {

        assertThrows(PasswordAndConfirmPasswordNotEqualException.class,
                ()->signUpValidationService.validatePasswordAndConfirmPassword("password123","password"));

    }

    @Test
    void shouldValidatePassword(){
        assertThrows(InvalidPassword.class,()->signUpValidationService.validatePassword("password"));
    }

    @Test
    void shouldThrowExceptionIfNameHasOnlySymbols() {
        assertThrows(InvalidUserName.class,()->signUpValidationService.validateUsername("password1@"));
    }

    @Test
    void shouldThrowExceptionIfNameDoesNotHaveAtleastOneAlphabet() {
        assertThrows(InvalidUserName.class,()->signUpValidationService.validateUsername(""));
    }
}
