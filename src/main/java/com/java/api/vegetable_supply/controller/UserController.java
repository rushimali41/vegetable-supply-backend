package com.java.api.vegetable_supply.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.api.vegetable_supply.dto.LoginRequestDTO;
import com.java.api.vegetable_supply.dto.UserDTO;
import com.java.api.vegetable_supply.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    // 1. Register a new User (Hotel)
    @PostMapping
    public UserDTO registerUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    // 2. Get All Users (Admin view)
    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    // 3. Get User Profile by ID
    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    
 // Inside UserController class
    @PostMapping("/login")
    public UserDTO login(@RequestBody LoginRequestDTO loginRequest) {
        return userService.loginUser(loginRequest.getPhone(), loginRequest.getPassword());
    }
}