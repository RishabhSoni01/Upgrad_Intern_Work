package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;


import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService {

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

    private List<Vehicle> generateVehicleList() {
        List<Vehicle> vehicleList = new ArrayList<>();

        // Generate sample vehicles
        Vehicle vehicle1 = new Vehicle();
        Tyre tyre1 = tyreService.generateTyre("Bridgestone");
        Speaker speaker1 = speakerService.generateSpeaker("Sony");
        vehicle1.setTyre(tyre1);
        vehicle1.setSpeaker(speaker1);
        vehicle1.setPrice(tyre1.getPrice() + speaker1.getPrice());
        //Vehicle vehicle1 = new Vehicle();// Sample calculation
        vehicleList.add(vehicle1);



        return vehicleList;
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

}
