package com.example.Java7.java7.repository;


import com.example.Java7.java7.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Vehicle, Long> {
}
