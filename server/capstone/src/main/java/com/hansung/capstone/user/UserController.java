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
        if (userService.check(user)){
            return new ResponseEntity(HttpStatus.OK);
        } else{
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/register")
    private ResponseEntity register(@RequestBody Optional<AppUser> req){
        AppUser user = req.get();
        userService.create(user.getUsername(), user.getPassword(), user.getEmail());
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
