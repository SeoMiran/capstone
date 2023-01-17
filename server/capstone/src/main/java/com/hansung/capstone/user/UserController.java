package com.hansung.capstone.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

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

    @PostMapping("/register")
    private ResponseEntity register(UserCreateForm userCreateForm, BindingResult bindingResult){
        userService.create(userCreateForm.getUsername(),
                userCreateForm.getPassword1(), userCreateForm.getEmail());
        return new ResponseEntity(HttpStatus.OK);
    }

//    @GetMapping("/hello")
//    private String hello(){
//        return "hello!";
//    }

}
