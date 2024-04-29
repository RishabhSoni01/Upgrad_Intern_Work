package org.example;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        VehicleService vehicleService = context.getBean(VehicleService.class);
        Vehicle mostExpensiveVehicle = vehicleService.getMostExpensiveVehicle();

        if (mostExpensiveVehicle != null) {
            System.out.println("Details of the most expensive vehicle:");
            System.out.println("Name: " + mostExpensiveVehicle.getName());
            System.out.println("Price: $" + mostExpensiveVehicle.getPrice());
            System.out.println("Speaker Brand: " + mostExpensiveVehicle.getSpeaker().getBrand());
            System.out.println("Tyre Brand: " + mostExpensiveVehicle.getTyre().getBrand());
        } else {
            System.out.println("No vehicles found.");
        }

        // Close the context
        context.close();
    }
}
