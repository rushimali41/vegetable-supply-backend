package com.java.api.vegetable_supply.service;

import com.java.api.vegetable_supply.dto.UserDTO;
import com.java.api.vegetable_supply.entity.User;
import com.java.api.vegetable_supply.mapper.UserMapper;
import com.java.api.vegetable_supply.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    // Get All Users (For Admin)
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> userMapper.toDTO(user))
                .collect(Collectors.toList());
    }

    // Get Single User by ID
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return userMapper.toDTO(user);
    }

    // Create / Register New User
    public UserDTO createUser(UserDTO userDTO) {
        // Default role if missing
        if (userDTO.getRole() == null || userDTO.getRole().isEmpty()) {
            userDTO.setRole("HOTEL");
        }
        User user = userMapper.toEntity(userDTO);
        User savedUser = userRepository.save(user);
        return userMapper.toDTO(savedUser);
    }
    
 // Inside UserService class
    public UserDTO loginUser(String phone, String password) {
        // Find user by phone
        User user = userRepository.findAll().stream()
                .filter(u -> u.getPhone().equals(phone))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Check password (In real app, use BCrypt!)
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid credentials");
        }

        return userMapper.toDTO(user);
    }
}