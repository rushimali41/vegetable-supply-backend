package com.java.api.vegetable_supply.repository;

import com.java.api.vegetable_supply.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}