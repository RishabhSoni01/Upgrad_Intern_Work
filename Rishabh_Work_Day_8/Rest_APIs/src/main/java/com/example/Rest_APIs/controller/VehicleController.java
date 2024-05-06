package com.example.Rest_APIs.controller;


import com.example.Rest_APIs.entity.Vehicle;
import com.example.Rest_APIs.service.VehicleService1;
import com.example.Rest_APIs.service.VehicleService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService1 vehicleService1;

    @Autowired
    private VehicleService2 vehicleService2;

    @GetMapping("/service1")
    public ResponseEntity<List<Vehicle>> getAllVehiclesService1() {

        List<Vehicle> vehicles = vehicleService1.getAllVehicles();
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @GetMapping("/service2")
    public ResponseEntity<List<Vehicle>> getAllVehiclesService2() {
        List<Vehicle> vehicles = vehicleService2.getAllVehicles();
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    // Add more methods for specific service if needed

    @PostMapping("/service1")
    public ResponseEntity<Vehicle> addVehicleService1(@Valid @RequestBody Vehicle vehicle) {
        System.out.println("post service1 hit");
        Vehicle newVehicle = vehicleService1.addVehicle(vehicle);
        return new ResponseEntity<>(newVehicle, HttpStatus.CREATED);
    }

    @PostMapping("/service2")
    public ResponseEntity<Vehicle> addVehicleService2(@Valid @RequestBody Vehicle vehicle) {
        Vehicle newVehicle = vehicleService2.addVehicle(vehicle);
        return new ResponseEntity<>(newVehicle, HttpStatus.CREATED);
    }

    // Implement other CRUD methods for each service

}



//
//import com.example.Rest_APIs.entity.Vehicle;
//import com.example.Rest_APIs.service.InventoryStore;
//import com.example.Rest_APIs.service.VehicleFactoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/vehicles")
//public class VehicleController {
//
//    @Autowired
//    private VehicleFactoryService vehicleFactoryService;
//
//    @Autowired
//    private InventoryStore inventoryStore;
//
//    @PostMapping("/add")
//    public ResponseEntity<Void> addVehicle(@Valid @RequestBody Vehicle vehicle, @RequestParam("factory") int factory) {
//        if (factory == 1) {
//            inventoryStore.addToFactory1Inventory(vehicle);
//        } else if (factory == 2) {
//            inventoryStore.addToFactory2Inventory(vehicle);
//        } else {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//        }
//        return ResponseEntity.status(HttpStatus.CREATED).build();
//    }
//
//    @GetMapping("/get")
//    public ResponseEntity<Vehicle> getVehicle(@RequestParam("factory") int factory, @RequestParam("index") int index) {
//        List<Vehicle> inventory = factory == 1 ? inventoryStore.getFactory1Inventory() : inventoryStore.getFactory2Inventory();
//        if (index >= 0 && index < inventory.size()) {
//            return ResponseEntity.ok().body(inventory.get(index));
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @PutMapping("/update")
//    public ResponseEntity<Void> updateVehicle(@Valid @RequestBody Vehicle vehicle, @RequestParam("factory") int factory,
//                                              @RequestParam("index") int index) {
//        List<Vehicle> inventory = factory == 1 ? inventoryStore.getFactory1Inventory() : inventoryStore.getFactory2Inventory();
//        if (index >= 0 && index < inventory.size()) {
//            inventory.set(index, vehicle);
//            return ResponseEntity.ok().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/delete")
//    public ResponseEntity<Void> deleteVehicle(@RequestParam("factory") int factory, @RequestParam("index") int index) {
//        List<Vehicle> inventory = factory == 1 ? inventoryStore.getFactory1Inventory() : inventoryStore.getFactory2Inventory();
//        if (index >= 0 && index < inventory.size()) {
//            inventory.remove(index);
//            return ResponseEntity.ok().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @GetMapping("/most-expensive")
//    public ResponseEntity<Vehicle> getMostExpensive(@RequestParam("factory") int factory) {
//        List<Vehicle> inventory = factory == 1 ? inventoryStore.getFactory1Inventory() : inventoryStore.getFactory2Inventory();
//        Vehicle mostExpensive = vehicleFactoryService.findMostExpensiveVehicle(inventory);
//        return ResponseEntity.ok().body(mostExpensive);
//    }
//
//    @GetMapping("/least-expensive")
//    public ResponseEntity<Vehicle> getLeastExpensive(@RequestParam("factory") int factory) {
//        List<Vehicle> inventory = factory == 1 ? inventoryStore.getFactory1Inventory() : inventoryStore.getFactory2Inventory();
//        Vehicle leastExpensive = vehicleFactoryService.findLeastExpensiveVehicle(inventory);
//        return ResponseEntity.ok().body(leastExpensive);
//    }
//}

