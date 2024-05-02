package com.example.Java7.java7.service;


import com.example.Java7.java7.model.Vehicle;
import com.example.Java7.java7.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("vehicleService2")
public class VehicleService2 {

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<Vehicle> getAllVehicles() {
        return inventoryRepository.findAll();
    }

    public Vehicle getVehicleById(Long id) {
        Optional<Vehicle> optionalVehicle = inventoryRepository.findById(id);
        if (optionalVehicle.isPresent()) {
            Vehicle vehicle = optionalVehicle.get();
            // Eagerly fetch associated entities
            vehicle.getSpeaker();
            vehicle.getTyre();
            return vehicle;
        } else {
            return null;
        }
    }



    public Vehicle addVehicle(Vehicle vehicle) {
        double increasedPrice = vehicle.getPrice() * 1.10; // Increase price by 10%
        vehicle.setPrice(increasedPrice);
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
