package com.java.api.vegetable_supply.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long userId;
    private String hotelName;
    private String phone;
    private String address;
    private String role; // "HOTEL" or "ADMIN"
    private String password; // In a real app, use a separate AuthDTO to hide this!
}