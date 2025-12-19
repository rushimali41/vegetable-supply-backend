package com.java.api.vegetable_supply.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class VegetableDTO {

	private Long vegetableId;
	
	private String vegetableName;

	private String category;

	private BigDecimal pricePerKg;

	private Integer stockQuantity;

	private String supplierName;

	private LocalDate lastRestocked;
}
