package com.example.Rest_APIs.service;


import com.example.Rest_APIs.entity.Vehicle;
import com.example.Rest_APIs.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("vehicleService1")
public class VehicleService1 {

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<Vehicle> getAllVehicles() {
        return inventoryRepository.findAll();
    }

    public Optional<Vehicle> getVehicleById(Long id) {
        return inventoryRepository.findById(id);
    }

    public Vehicle addVehicle(Vehicle vehicle) {
        return inventoryRepository.save(vehicle);
    }

    public Vehicle updateVehicle(Long id, Vehicle updatedVehicle) {
        Optional<Vehicle> optionalVehicle = inventoryRepository.findById(id);
        if (optionalVehicle.isPresent()) {
            Vehicle existingVehicle = optionalVehicle.get();
            existingVehicle.setPrice(updatedVehicle.getPrice());
            // Update other fields if necessary
            return inventoryRepository.save(existingVehicle);
        } else {
            return null;
        }
    }

    public void deleteVehicle(Long id) {
        inventoryRepository.deleteById(id);
    }

    // Implement additional methods as needed
}
