package org.example;


import org.example.model.Vehicle;
import org.example.service.VehicleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class, args);

        VehicleService vehicleService = context.getBean(VehicleService.class);

        List<Vehicle> vehicles = vehicleService.generateVehicleList(5);
        Vehicle mostExpensiveVehicle = vehicleService.findMostExpensiveVehicle(vehicles);

        System.out.println("Most expensive vehicle: " + mostExpensiveVehicle);

        SpringApplication.exit(context);
    }
}
