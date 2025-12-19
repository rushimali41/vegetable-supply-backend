package com.java.api.vegetable_supply.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "vegetables")
public class Vegetable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vegetable_id") // <--- ADD THIS LINE
    private Long vegetableId;
    
    @Column(nullable = false)
    private String vegetableName;
    
    private String category;
    
    @Column(name = "price_per_kg")
    private BigDecimal pricePerKg;
    
    @Column(name = "stock_quantity")
    private Integer stockQuantity;
    
    @Column(name = "supplier_name")
    private String supplierName;
    
    @Column(name = "last_restocked")
    private LocalDate lastRestocked;
}