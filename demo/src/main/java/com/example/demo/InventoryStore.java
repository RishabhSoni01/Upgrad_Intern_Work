package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class InventoryStore {
    private List<Vehicle> vehicles = new ArrayList<>();
    private long nextId = 1;

    public Vehicle addVehicle(Vehicle vehicle) {
        vehicle.setId(nextId++);
        vehicles.add(vehicle);
        return vehicle;
    }

    public Vehicle getVehicleById(long id) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId() == id) {
                return vehicle;
            }
        }
        return null;
    }

    public Vehicle updateVehicle(long id, Vehicle vehicle) {
        for (int i = 0; i < vehicles.size(); i++) {
            Vehicle v = vehicles.get(i);
            if (v.getId() == id) {
                vehicle.setId(id);
                vehicles.set(i, vehicle);
                return vehicle;
            }
        }
        return null;
    }

    public boolean deleteVehicle(long id) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId() == id) {
                vehicles.remove(vehicle);
                return true;
            }
        }
        return false;
    }

    public Vehicle getMostExpensiveVehicle() {
        if (vehicles.isEmpty()) {
            return null;
        }
        Vehicle mostExpensive = vehicles.get(0);
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPrice() > mostExpensive.getPrice()) {
                mostExpensive = vehicle;
            }
        }
        return mostExpensive;
    }

    public Vehicle getCheapestVehicle() {
        if (vehicles.isEmpty()) {
            return null;
        }
        Vehicle cheapest = vehicles.get(0);
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPrice() < cheapest.getPrice()) {
                cheapest = vehicle;
            }
        }
        return cheapest;
    }
}
