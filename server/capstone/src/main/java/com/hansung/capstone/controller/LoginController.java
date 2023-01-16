package com.hansung.capstone.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @GetMapping("/check")
    private ResponseEntity loginCheck(@RequestParam String id, @RequestParam String pwd) {
        String id1 = "1234";
        String pwd1 = "5678";
        if (id.equals(id1) && pwd.equals(pwd1)){
            return new ResponseEntity(HttpStatus.OK);
        } else{
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
    
}
