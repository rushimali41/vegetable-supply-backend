	package com.java.api.vegetable_supply.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.java.api.vegetable_supply.dto.VegetableDTO;
import com.java.api.vegetable_supply.service.VegetableService;

@RestController
@RequestMapping("/api/v1/vegetables")
@CrossOrigin(origins = "*") 
public class VegetableController {

    @Autowired
    private VegetableService vegetableService;

    // 1. Get all vegetables
    @GetMapping
    public List<VegetableDTO> getAllVegetables() {
        return vegetableService.getAllVegetables();
    }

    // 2. Add a new vegetable
    @PostMapping
    public VegetableDTO addVegetable(@RequestBody VegetableDTO vegetableDTO) {
        return vegetableService.addVegetable(vegetableDTO);
    }

    // 3. Delete a vegetable
    @DeleteMapping("/{id}")
    public void deleteVegetable(@PathVariable Long id) {
        vegetableService.deleteVegetable(id);
    }
}