package com.hansung.capstone.dto;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public AppUser create(String username, String password, String email) {
        AppUser user = new AppUser();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        this.userRepository.save(user);
        return user;
    }

//    public User getUser(String username){
//        Optional<User> user = this.userRepository.findByUsername(username);
//        if(user.isPresent()){
//            return user.get();
//        }else{
//            throw new DataNotFoundException("");
//        }

}
