package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity register (@RequestBody User user) {
        userService.registerUser(user);
        return new ResponseEntity("Success register", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user) {
        if(userService.authenticate(user) != null) {
            return new ResponseEntity("Login success!", HttpStatus.OK);
        }
        else {
            return new ResponseEntity("Login failed!", HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
