package com.hansung.capstone.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/login")
    private String loginCheck(
            @RequestParam String id, @RequestParam String pwd
    ) {
        System.out.println(id);
        System.out.println(pwd);
        return id+pwd;
    }
}
