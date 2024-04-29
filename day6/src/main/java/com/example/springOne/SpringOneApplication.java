package com.example.springOne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringOneApplication.class, args);

	    Vehicle mostExpensive=VehicleService.getMostExpensiveVehicle();
		System.out.println("Most Expensive Vehicle Details:");
		System.out.println("  Price: Rs" + mostExpensive.getPrice());
		System.out.println("  Speaker Brand: " + mostExpensive.getSpeaker().getBrand());
		System.out.println("  Tyre Brand: " + mostExpensive.getTyre().getBrand());
	}

}
