package com.java.api.vegetable_supply.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.api.vegetable_supply.dto.OrderRequestDTO;
import com.java.api.vegetable_supply.entity.Order;
import com.java.api.vegetable_supply.service.OrderService;

@RestController
@RequestMapping("/api/v1/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private OrderService orderService;
    
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders(); 
        // (You will need to add getAllOrders() to your Service and Repository first)
    }

    @PostMapping
    public Order placeOrder(@RequestBody OrderRequestDTO orderRequest) {
        return orderService.createOrder(orderRequest);
    }
}