package com.example.Java7.java7.service;


import com.example.Java7.java7.model.Vehicle;
import com.example.Java7.java7.repository.InventoryRepository;
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
        return inventoryRepository.save(vehicle);
    }

    public Vehicle updateVehicle(Long id, Vehicle updatedVehicle) {
        Optional<Vehicle> optionalVehicle = inventoryRepository.findById(id);
        if (optionalVehicle.isPresent()) {
            Vehicle existingVehicle = optionalVehicle.get();
            existingVehicle.setPrice(updatedVehicle.getPrice());
            existingVehicle.setSpeaker(updatedVehicle.getSpeaker());
            existingVehicle.setTyre(updatedVehicle.getTyre());
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
