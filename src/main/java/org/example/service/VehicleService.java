package org.example.service;

import org.example.model.Vehicle;
import org.springframework.stereotype.Component;


@Component
public interface VehicleService {

    public void generateVehicleList(int numberOfVehicles);

    public Vehicle findMostExpensiveVehicle();
}
