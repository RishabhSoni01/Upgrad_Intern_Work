package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;


import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private InventoryStore inventoryStore;

    public Vehicle addVehicle(Vehicle vehicle) {
        return inventoryStore.addVehicle(vehicle);
    }

    public Vehicle getVehicleById(long id) {
        return inventoryStore.getVehicleById(id);
    }

    public Vehicle updateVehicle(long id, Vehicle vehicle) {
        return inventoryStore.updateVehicle(id, vehicle);
    }

    public boolean deleteVehicle(long id) {
        return inventoryStore.deleteVehicle(id);
    }

    public Vehicle getMostExpensiveVehicle() {
        return inventoryStore.getMostExpensiveVehicle();
    }

    public Vehicle getCheapestVehicle() {
        return inventoryStore.getCheapestVehicle();
    }
}
