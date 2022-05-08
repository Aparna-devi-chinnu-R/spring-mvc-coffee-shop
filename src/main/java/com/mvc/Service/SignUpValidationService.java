package com.mvc.Service;

import com.mvc.Exceptions.InvalidPassword;
import com.mvc.Exceptions.InvalidUserName;
import com.mvc.Exceptions.PasswordAndConfirmPasswordNotEqualException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SignUpValidationService {
    public boolean validatePasswordAndConfirmPassword(String password, String confirmPassword) throws PasswordAndConfirmPasswordNotEqualException {
        if(password.equals(confirmPassword)) return true;
        else{
            throw new PasswordAndConfirmPasswordNotEqualException("Password and Confirm Password should match");
        }
    }

    public void validatePassword(String password) throws InvalidPassword {
        if(!password.matches("\"^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$\"")){
            throw new InvalidPassword("password must follow the instructions given");
        }
    }

    public void validateUsername(String username) throws InvalidUserName {
        if(!username.matches("[a-zA-Z]")){
            throw new InvalidUserName("Username is Invalid");
        }
    }

    public List<String> validateUserSignUp(String name, String password, String confirmPassword) {

        List<String> validationMessages = new ArrayList<>();
        try {
            validatePassword(password);
        } catch (InvalidPassword invalidPassword) {
            validationMessages.add(invalidPassword.getMessage());
        }

        try {
            validatePasswordAndConfirmPassword(password,confirmPassword);
        } catch (PasswordAndConfirmPasswordNotEqualException passwordAndConfirmPasswordNotEqualException) {
            validationMessages.add(passwordAndConfirmPasswordNotEqualException.getMessage());
        }

        return  validationMessages;
    }
}
