package org.example.service;



import org.example.model.Speaker;
import org.example.model.Tyre;
import org.example.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService {

    private final SpeakerService speakerService;
    private final TyreService tyreService;

    @Autowired
    public VehicleService(SpeakerService speakerService, TyreService tyreService) {
        this.speakerService = speakerService;
        this.tyreService = tyreService;
    }

    @PostConstruct
    public void init() {
        System.out.println("VehicleService bean has been created.");
    }

    public List<Vehicle> generateVehicleList(int numberOfVehicles) {
        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < numberOfVehicles; i++) {


                     Vehicle v1 =new Vehicle(speakerService,tyreService);
//            Speaker speaker = speakerService.generateRandomSpeaker();
//            Tyre tyre = tyreService.generateTyre("Bridgestone", 300);
//
//            int price = speaker.getPrice() + tyre.getPrice();
//            Vehicle vehicle = new Vehicle(speaker, tyre, price);
            vehicles.add(v1);
        }
        return vehicles;
    }

    public Vehicle findMostExpensiveVehicle(List<Vehicle> vehicles) {
        Vehicle mostExpensive = null;
        int maxPrice = Integer.MIN_VALUE;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPrice() > maxPrice) {
                mostExpensive = vehicle;
                maxPrice = vehicle.getPrice();
            }
        }
        return mostExpensive;
    }
}





