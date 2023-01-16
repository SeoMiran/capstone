package com.hansung.capstone.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@AutoConfigureMockMvc
@AutoConfigureWebMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;


    @Test
    @DisplayName("Get login check - /login/check")
    void loginCheckTest() throws Exception {
        String id = "1234";
        String pwd = "5678";

        mockMvc.perform(get("/login/check")
                        .param("id", id)
                        .param("pwd", pwd))
                .andExpect(status().isOk());
    }

//    @Test
//    @DisplayName("Post register test - /login/register")
//    void registerTest() throws Exception{
//        String id = "hoon";
//        String pwd = "1234";
//        String email = "test@test.com";
//
//        mockMvc.perform(post("/login/register")
//                        .param("username", id)
//                        .param("pwd", pwd)
//                        .param("email", email))
//                .andExpect(status().isOk());
//    }
}