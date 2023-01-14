package com.hansung.capstone.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/login")
    private HttpStatusCode loginCheck(@RequestParam String id, @RequestParam String pwd) {
        String id1 = "1234";
        String pwd1 = "5678";
        if (id.equals(id1) && pwd.equals(pwd1)){
            return HttpStatus.OK;
        } else{
            return HttpStatus.BAD_REQUEST;
        }
    }
}
