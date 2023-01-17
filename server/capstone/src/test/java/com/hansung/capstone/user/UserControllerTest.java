package com.hansung.capstone.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserControllerTest.class)
class UserControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    void testAdd() {
        assertEquals(42, Integer.sum(19, 23));
    }

    @Test
    @DisplayName("Get login check - /login/check")
    void loginCheckTest() throws Exception {
        String id = "1234";
        String pwd = "5678";

        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/login/check")
                        .param("id", id)
                        .param("pwd", pwd))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Post register test - /login/register")
    void registerTest() throws Exception{
        String id = "ch";
        String pwd = "1234";
        String email = "test11@test.com";

        mockMvc.perform(post("http://localhost:8080/login/register")
                        .param("username", id)
                        .param("password1", pwd)
                        .param("password2", pwd)
                        .param("email", email))
                .andExpect(status().isOk());
    }
}