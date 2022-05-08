package com.mvc.Controller;

import com.mvc.Service.SignUpValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sign-up")
public class SignUpController {

    @Autowired
    private SignUpValidationService signUpValidationService;


    @GetMapping
    public String signUp(){
        return "signUp";
    }

    @PostMapping
    public String saveNewUser(@RequestParam(name = "username") String name ,
                              @RequestParam(name="password") String password,
                              @RequestParam(name="confirmPassword") String confirmPassword, ModelMap modalMap){

        List<String> validationMessages = signUpValidationService.validateUserSignUp(name, password, confirmPassword);
        if(validationMessages.size()!=0) {
            modalMap.put("status", validationMessages.toString());
            return "signUp";
        }
        return "login";
    }

}
