package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Vehicle;
import com.example.demo.Speaker;
import com.example.demo.VehicleService;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);

		Vehicle mostExpensive = VehicleService.getMostExpensiveVehicle();
		System.out.println("Most Expensive Vehicle Details:");
		System.out.println("  Price: $" + mostExpensive.getPrice());
		System.out.println("  Speaker Brand: " + mostExpensive.getSpeaker().getBrand());
		System.out.println("  Tyre Brand: " + mostExpensive.getTyre().getBrand());
	}

}
