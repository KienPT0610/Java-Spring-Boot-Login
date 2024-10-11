package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        if(userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("Email already registered!");
        }
        return userRepository.save(user);
    }

    public User authenticate(User user) {
        User userLogin = userRepository.findByEmail(user.getEmail());
        if(userLogin != null) {
            if(userLogin.getPassword().equals(user.getPassword())) {
                return user;
            } else {
                return null;
            }
        }
        return null;
    }

    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }
}
