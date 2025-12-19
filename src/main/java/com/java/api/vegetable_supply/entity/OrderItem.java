package com.java.api.vegetable_supply.entity;

import com.fasterxml.jackson.annotation.JsonIgnore; // <--- IMPORT THIS
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // --- ADD @JsonIgnore HERE ---
    // This stops the infinite loop
    @JsonIgnore 
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "vegetable_id", nullable = false)
    private Vegetable vegetable;

    private Double quantity;

    private BigDecimal priceAtOrderTime;
}