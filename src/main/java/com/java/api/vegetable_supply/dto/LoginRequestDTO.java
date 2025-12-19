package com.java.api.vegetable_supply.dto;
import lombok.Data;

@Data
public class LoginRequestDTO {
    private String phone;
    private String password;
}