package com.example.Sprinboot_Demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;


import java.util.ArrayList;
import java.util.List;

@Service
public abstract class VehicleService {

    private final TyreService tyreService;
    private final SpeakerService speakerService;

    private List<Vehicle> vehicles;

    @Autowired
    public VehicleService(TyreService tyreService, SpeakerService speakerService) {
        this.tyreService = tyreService;
        this.speakerService = speakerService;
    }

    @PostConstruct
    public void initialize() {
        // Initialize vehicles after dependencies are injected
        vehicles = generateVehicleList();
    }

    protected  double calculateAdditionalCost(String factoryName){
        return 0;
    };

    private List<Vehicle> generateVehicleList() {
        List<Vehicle> vehicleList = new ArrayList<>();

        Vehicle vehicle1 = generateVehicle("Factory1");
        vehicleList.add(vehicle1);

        // Generate Vehicle2 using Factory2
        Vehicle vehicle2 = generateVehicle("Factory2");
        vehicleList.add(vehicle2);



        return vehicleList;
    }

    private Vehicle generateVehicle(String factoryName) {
        Vehicle vehicle = new Vehicle();
        Tyre tyre = tyreService.generateTyre("Bridgestone");
        Speaker speaker = speakerService.generateSpeaker("Sony");

        double additionalCost = calculateAdditionalCost(factoryName);
        double totalTirePrice = tyre.getPrice() + (tyre.getPrice() * additionalCost);

        vehicle.setTyre(tyre);
        vehicle.setSpeaker(speaker);
        vehicle.setPrice(totalTirePrice + speaker.getPrice());

        return vehicle;
    }

    public Vehicle findMostExpensiveVehicle() {
        Vehicle mostExpensive = null;
        double maxPrice = Double.MIN_VALUE;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPrice() > maxPrice) {
                maxPrice = vehicle.getPrice();
                mostExpensive = vehicle;
            }
        }
        return mostExpensive;
    }

    public abstract double calculateAdditionalCost();
}