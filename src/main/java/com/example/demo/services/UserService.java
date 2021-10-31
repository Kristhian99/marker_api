package com.example.demo.services;


import com.example.demo.repository.UserRepository;
import com.example.demo.users.STATE;
import com.example.demo.users.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return  userRepository.findAll();
    }

    public  String accreditUser(String email, String pass) {
        User user=userRepository.findUserByEmail(email).orElse(null);
        if(user==null) return "YOU DON´T EXIST :(";
        else return accreditCredentials(user,pass);
    }

    private String accreditCredentials(User user, String pass) {
        if(user.getPassword().equals(pass)){
            if(user.getState()== STATE.ADMIN)
                return "valid";
            else
                return "YOU DON´T HAVE PERMISSIONS :(";
        }
        return "INCORRECTED PASSWORD :/";
    }


    public String updateUser(String email){
        User user=userRepository.findUserByEmail(email).orElse(null);
        if(user==null)
        return "The user doesn´t exist";
        else {
            user.setEmail("nuevo@emai.com");
            userRepository.save(user);
            return "The user was update";
        }

    }



}
