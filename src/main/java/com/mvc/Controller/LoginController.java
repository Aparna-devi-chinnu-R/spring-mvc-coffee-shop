package com.mvc.Controller;

import com.mvc.Service.UserValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private UserValidationService userValidationService;


    @GetMapping
    public String login(){
        return "login";
    }

    @PostMapping
    public String loginUser(@RequestParam(name="Name") String name , @RequestParam(name="Password") String password, ModelMap modelMap){
        if(userValidationService.validateUserAndPassword(name,password)){
            return "home";
        }else{
            modelMap.put("status","Login Failed !");
            return "login";
        }

    }


}
