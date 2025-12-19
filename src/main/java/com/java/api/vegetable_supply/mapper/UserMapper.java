package com.java.api.vegetable_supply.mapper;

import com.java.api.vegetable_supply.dto.UserDTO;
import com.java.api.vegetable_supply.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    // Convert Entity -> DTO (Sending data to frontend)
    public UserDTO toDTO(User user) {
        if (user == null) return null;
        
        UserDTO dto = new UserDTO();
        dto.setUserId(user.getUserId());
        dto.setHotelName(user.getHotelName());
        dto.setPhone(user.getPhone());
        dto.setAddress(user.getAddress());
        dto.setRole(user.getRole());
        // We generally DO NOT send the password back to the frontend for security
        return dto;
    }

    // Convert DTO -> Entity (Saving data to DB)
    public User toEntity(UserDTO dto) {
        if (dto == null) return null;
        
        User user = new User();
        if (dto.getUserId() != null) {
            user.setUserId(dto.getUserId());
        }
        user.setHotelName(dto.getHotelName());
        user.setPhone(dto.getPhone());
        user.setAddress(dto.getAddress());
        user.setRole(dto.getRole());
        user.setPassword(dto.getPassword()); // In real app, encrypt this here!
        
        return user;
    }
}