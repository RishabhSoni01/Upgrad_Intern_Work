package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Comparator;
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
    public void generateVehicles() {
        vehicles = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Tyre tyre = tyreService.generateTyre();
            Speaker speaker = speakerService.generateSpeaker();
            vehicles.add(new Vehicle(tyre, speaker));
        }
    }

    public void printMostExpensiveVehicle() {
        Vehicle mostExpensive = vehicles.stream()
                .max(Comparator.comparingDouble(Vehicle::getPrice))
                .orElse(null);
        System.out.println("Most Expensive Vehicle: " + mostExpensive);
    }

    public abstract double calculateAdditionalCost();
}
