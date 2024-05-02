package org.example;

import org.example.model.Vehicle;
import org.example.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
public class Main implements CommandLineRunner {

    @Autowired
    @Qualifier("VehicleService1")
    private VehicleService vehicleService1;

    @Autowired
    @Qualifier("VehicleService2")
    private VehicleService vehicleService2;

    @Override
    public void run(String... args) {

        vehicleService1.generateVehicleList(10);

        Vehicle mostExpensiveVehicle = vehicleService1.findMostExpensiveVehicle();

        System.out.println("Most expensive vehicle: " + mostExpensiveVehicle);
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
