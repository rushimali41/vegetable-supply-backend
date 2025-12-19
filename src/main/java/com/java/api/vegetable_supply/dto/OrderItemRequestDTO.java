package com.java.api.vegetable_supply.dto;
import lombok.Data;

@Data
public class OrderItemRequestDTO {
    private Long vegetableId;
    private Double quantity;
}