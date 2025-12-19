package com.java.api.vegetable_supply.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.api.vegetable_supply.dto.OrderRequestDTO;
import com.java.api.vegetable_supply.entity.Order;
import com.java.api.vegetable_supply.entity.OrderItem;
import com.java.api.vegetable_supply.entity.User;
import com.java.api.vegetable_supply.entity.Vegetable;
import com.java.api.vegetable_supply.repository.OrderRepository;
import com.java.api.vegetable_supply.repository.UserRepository;
import com.java.api.vegetable_supply.repository.VegetableRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private VegetableRepository vegetableRepository;

	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	@Transactional
	public Order createOrder(OrderRequestDTO request) {

		// 1. Validate User
		User user = userRepository.findById(request.getUserId())
				.orElseThrow(() -> new RuntimeException("User not found: " + request.getUserId()));

		// 2. Validate Vegetable
		Vegetable veg = vegetableRepository.findById(request.getVegetableId())
				.orElseThrow(() -> new RuntimeException("Vegetable not found: " + request.getVegetableId()));

		// 3. Create the Main Order
		Order order = new Order();
		order.setUser(user);
		order.setOrderDate(LocalDateTime.now());
		order.setStatus("PENDING");

		// Inside createOrder method in OrderService.java

	    // ... (previous code where you set user, date, status) ...

	    // 4. Create the Single Order Item
	    OrderItem orderItem = new OrderItem();
	    orderItem.setOrder(order); 
	    orderItem.setVegetable(veg);
	    orderItem.setQuantity(request.getQuantity());
	    orderItem.setPriceAtOrderTime(veg.getPricePerKg()); 

	    // --- NEW BILL CALCULATION CODE STARTS HERE ---
	    
	    // Convert Double quantity to BigDecimal for precise money math
	    java.math.BigDecimal quantityBD = java.math.BigDecimal.valueOf(request.getQuantity());
	    
	    // Calculate: Price (Per Kg) * Quantity
	    java.math.BigDecimal totalBill = veg.getPricePerKg().multiply(quantityBD);
	    
	    order.setTotalAmount(totalBill); // Set the calculated bill on the Order

	    // --- NEW BILL CALCULATION CODE ENDS HERE ---

	    order.setOrderItems(Collections.singletonList(orderItem));

	    return orderRepository.save(order);
	}
}