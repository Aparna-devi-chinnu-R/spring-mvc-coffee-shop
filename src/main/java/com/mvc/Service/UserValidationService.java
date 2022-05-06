package com.mvc.Service;

import org.springframework.stereotype.Service;

@Service
public class UserValidationService {

    public static final String VALID_USERNAME = "DummyName";
    public static final String VALID_PASSWORD = "DummyPassword";

    public boolean validateUserAndPassword(String user, String password){
        return user.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD);
    }
}
