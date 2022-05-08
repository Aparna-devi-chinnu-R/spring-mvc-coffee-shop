package com.mvc.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class SignUpControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldDisplaySignupPage() throws Exception {
        mockMvc.perform(get("/sign-up")).andExpect(content().json("home"));
    }

    @Test
    void shouldReturnToLoginPageAfterSuccessfulSignUp() throws Exception {
        mockMvc.perform(post("/sign-up")).andExpect(content().json("login"));
    }

    @Test
    void shouldNotRedirectToLoginPageIfPasswordAndConfirmPasswordAreDifferent() throws Exception {

        mockMvc.perform(post("/sign-up")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"name\",\"password\":\"password\",\"confirmPassword\":\"wrongPassword\"}"))
                .andExpect(content().json("signUp"));
    }
}
