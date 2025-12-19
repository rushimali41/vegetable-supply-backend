package com.java.api.vegetable_supply.service;

import com.java.api.vegetable_supply.dto.VegetableDTO;
import com.java.api.vegetable_supply.entity.Vegetable;
import com.java.api.vegetable_supply.mapper.VegetableMapper;
import com.java.api.vegetable_supply.repository.VegetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VegetableService {

    @Autowired
    private VegetableRepository vegetableRepository;

    @Autowired
    private VegetableMapper vegetableMapper;

    // Get all
    public List<VegetableDTO> getAllVegetables() {
        return vegetableRepository.findAll()
                .stream()
                .map(vegetable -> vegetableMapper.toDTO(vegetable))
                .collect(Collectors.toList());
    }

    // Add
    public VegetableDTO addVegetable(VegetableDTO vegetableDTO) {
        Vegetable vegetable = vegetableMapper.toEntity(vegetableDTO);
        Vegetable savedVegetable = vegetableRepository.save(vegetable);
        return vegetableMapper.toDTO(savedVegetable);
    }

    // Delete
    public void deleteVegetable(Long id) {
        vegetableRepository.deleteById(id);
    }
}