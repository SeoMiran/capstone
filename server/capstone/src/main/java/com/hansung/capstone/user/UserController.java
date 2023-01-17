package com.hansung.capstone.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("/login")
public class UserController {

    private final UserService userService;

    private final UserRepository userRepository;


    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }


    @PostMapping("/check")
    private ResponseEntity loginCheck(@RequestBody Optional<AppUser> req) {
        AppUser user = req.get();
        AppUser check = userRepository.findByusername(user.getUsername()).get();
        if (user.getUsername().equals(check.getUsername()) && user.getPassword().equals(check.getPassword())){
            return new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/register")
    private ResponseEntity register(UserCreateForm userCreateForm, BindingResult bindingResult){
        userService.create(userCreateForm.getUsername(),
                userCreateForm.getPassword1(), userCreateForm.getEmail());
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/test")
    public String mapRequest(@RequestBody HashMap<String, String> param){
        System.out.println("param : " + param);
        System.out.println(param.get("username"));
        return param.toString();
    }

    @GetMapping("/hello")
    public Optional<AppUser> hello(){
        AppUser user = userRepository.findByusername("hoon").get();
        System.out.println(user.getPassword());
        return userRepository.findByusername("hoon");
    }

    @GetMapping("/hi")
    public String hi(){
        return "hello";
    }

}
