package com.example.springOne;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class VehicleService {

    @Autowired
    private Tyre tyre;

    @Autowired
    private Speaker speaker;

    private static List<Vehicle> vehicles;

    private double generateRandomPrice() {
        return Math.random() * 100000;
    }

    @PostConstruct
    public void generateVehicles() {
        vehicles = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Vehicle vehicle = new Vehicle(this.generateRandomPrice(), speaker, tyre);
            vehicles.add(vehicle);
        }
    }

    public Vehicle getMostExpensiveVehicle() {
        if (vehicles == null || vehicles.isEmpty()) {
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
}
