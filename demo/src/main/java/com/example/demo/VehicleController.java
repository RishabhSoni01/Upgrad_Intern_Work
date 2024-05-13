package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/add")
    public ResponseEntity<Vehicle> addVehicle(@Valid @RequestBody Vehicle vehicle) {
        Vehicle addedVehicle = vehicleService.addVehicle(vehicle);
        return new ResponseEntity<>(addedVehicle, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable long id) {
        Vehicle vehicle = vehicleService.getVehicleById(id);
        if (vehicle != null) {
            return new ResponseEntity<>(vehicle, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable long id, @Valid @RequestBody Vehicle vehicle) {
        Vehicle updatedVehicle = vehicleService.updateVehicle(id, vehicle);
        if (updatedVehicle != null) {
            return new ResponseEntity<>(updatedVehicle, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable long id) {
        boolean deleted = vehicleService.deleteVehicle(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/expensive")
    public ResponseEntity<Vehicle> getMostExpensiveVehicle() {
        Vehicle mostExpensiveVehicle = vehicleService.getMostExpensiveVehicle();
        if (mostExpensiveVehicle != null) {
            return new ResponseEntity<>(mostExpensiveVehicle, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/cheapest")
    public ResponseEntity<Vehicle> getCheapestVehicle() {
        Vehicle cheapestVehicle = vehicleService.getCheapestVehicle();
        if (cheapestVehicle != null) {
            return new ResponseEntity<>(cheapestVehicle, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
