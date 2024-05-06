package com.example.Rest_APIs.repository;


import com.example.Rest_APIs.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Vehicle, Long> {
}