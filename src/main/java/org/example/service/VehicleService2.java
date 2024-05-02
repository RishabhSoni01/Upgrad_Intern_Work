package org.example.service;

import org.example.Inventory.Inventory;
import org.example.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component("VehicleService2")
public class VehicleService2 implements VehicleService{
    private final SpeakerService speakerService;
    private final TyreService tyreService;

    @Autowired
    public Inventory inventory;
    private List<Vehicle> Vehicles;

    @Autowired
    public VehicleService2(SpeakerService speakerService, TyreService tyreService) {
        this.speakerService = speakerService;
        this.tyreService = tyreService;
    }

    @PostConstruct
    public void init() {
        System.out.println("VehicleService bean has been created.");
    }

    @Override
    public void generateVehicleList(int numberOfVehicles) {
        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < numberOfVehicles; i++) {


            Vehicle v1 =new Vehicle(speakerService,tyreService);
//            Speaker speaker = speakerService.generateRandomSpeaker();
//            Tyre tyre = tyreService.generateTyre("Bridgestone", 300);
//
//            int price = speaker.getPrice() + tyre.getPrice();
//            Vehicle vehicle = new Vehicle(speaker, tyre, price);
            v1.setPrice(  (int)(v1.getPrice()*(1.1)));
            inventory.addVehicle(v1);
            this.Vehicles.add(v1);
        }

    }

    @Override
    public Vehicle findMostExpensiveVehicle() {
        Vehicle mostExpensive = null;
        int maxPrice = Integer.MIN_VALUE;
        for (Vehicle vehicle : Vehicles) {
            if (vehicle.getPrice() > maxPrice) {
                mostExpensive = vehicle;
                maxPrice = vehicle.getPrice();
            }
        }
        return mostExpensive;
    }
}
