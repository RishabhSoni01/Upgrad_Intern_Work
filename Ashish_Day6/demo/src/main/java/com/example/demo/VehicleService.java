package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VehicleService {

    @Autowired
    private Speaker speaker;

    @Autowired
    private Tyre tyre;

    private static List<Vehicle> vehicles;

    @PostConstruct
    public void generateVehicles() {
        vehicles = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Vehicle vehicle = new Vehicle(this.generateRandomPrice(), speaker, tyre);
            vehicles.add(vehicle);
        }
    }

    private double generateRandomPrice() {
        return Math.random() * 10000;
    }

    public static Vehicle getMostExpensiveVehicle() {
        Vehicle mostExpensive = vehicles.get(0);
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPrice() > mostExpensive.getPrice()) {
                mostExpensive = vehicle;
            }
        }
        return mostExpensive;
    }
}
