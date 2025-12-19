package com.java.api.vegetable_supply.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.api.vegetable_supply.entity.Vegetable;

@Repository
public interface VegetableRepository extends JpaRepository<Vegetable, Long> {
    // This gives you methods like save(), findAll(), findById() automatically.
}