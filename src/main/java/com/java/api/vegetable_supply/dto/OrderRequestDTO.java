package com.java.api.vegetable_supply.dto;

import lombok.Data;
import java.util.List;

@Data
public class OrderRequestDTO {
    private Long userId; // Who is ordering?
//    private List<OrderItemRequestDTO> items; // What are they ordering?
    private Long vegetableId;
    private Double quantity;
}