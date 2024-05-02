package com.example.Java7.java7.controller;

import com.example.Java7.java7.model.Vehicle;
import com.example.Java7.java7.service.VehicleService1;
import com.example.Java7.java7.service.VehicleService2;
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


    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById1(@PathVariable Long id) {
        Vehicle vehicle = vehicleService1.getVehicleById(id);
        if (vehicle != null) {
            return ResponseEntity.ok(vehicle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicleById(@PathVariable Long id) {
        Vehicle vehicle = vehicleService1.getVehicleById(id);
        if (vehicle!=null) {
            vehicleService1.deleteVehicle(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> updateVehicleById(@PathVariable Long id, @Valid @RequestBody Vehicle updatedVehicle) {
        Vehicle vehicle = vehicleService1.updateVehicle(id,updatedVehicle);
        if (vehicle!=null) {
            return new ResponseEntity<>(vehicle, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




    // Implement other CRUD methods for each service

}
