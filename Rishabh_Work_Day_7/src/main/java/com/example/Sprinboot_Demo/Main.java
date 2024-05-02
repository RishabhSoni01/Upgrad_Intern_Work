//package com.example.Sprinboot_Demo;
//
//import com.example.Sprinboot_Demo.service.Factory1VehicleService;
//import com.example.Sprinboot_Demo.service.Factory2VehicleService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class Main implements CommandLineRunner {
//
//    private final Factory1VehicleService factory1VehicleService;
//    private final Factory2VehicleService factory2VehicleService;
//
//    @Autowired
//    public Main(Factory1VehicleService factory1VehicleService, Factory2VehicleService factory2VehicleService) {
//        this.factory1VehicleService = factory1VehicleService;
//        this.factory2VehicleService = factory2VehicleService;
//    }
//
//    @Override
//    public void run(String... args) {
//        factory1VehicleService.manufactureVehicles(5);
//        factory2VehicleService.manufactureVehicles(5);
//    }
//}