package com.example.demo.Controllers;

import com.example.demo.services.UserService;
import com.example.demo.users.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/vi/Users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> fetchAllUsers(){
        return userService.getAllUsers();
    }

    @PutMapping
    public String updateUser(){
        return userService.updateUser("badbunny@gmail.com");
    }

    @GetMapping("/login")
    public String  AcrreditUser(@RequestParam(value="email")String email,@RequestParam(value = "pass")String pass){
        return userService.accreditUser(email,pass);
    }




}
