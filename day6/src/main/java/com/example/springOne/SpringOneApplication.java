package com.example.springOne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext; 

@SpringBootApplication
public class SpringOneApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringOneApplication.class, args);
        VehicleService vehicleService = context.getBean(VehicleService.class);
        Vehicle mostExpensive = vehicleService.getMostExpensiveVehicle();
        if (mostExpensive != null) {
            System.out.println("Most Expensive Vehicle Details:");
            System.out.println("  Price: Rs" + mostExpensive.getPrice());
            System.out.println("  Speaker Brand: " + mostExpensive.getSpeaker().getBrand());
            System.out.println("  Tyre Brand: " + mostExpensive.getTyre().getBrand());
        } else {
            System.out.println("No vehicles generated.");
        }
    }

}
