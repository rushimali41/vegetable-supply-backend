package com.java.api.vegetable_supply.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String hotelName;

    @Column(nullable = false, unique = true) // Phone numbers should be unique
    private String phone;

    private String address;

    private String password; // Simple password for now
    
    private String role; // "HOTEL" or "ADMIN"
}