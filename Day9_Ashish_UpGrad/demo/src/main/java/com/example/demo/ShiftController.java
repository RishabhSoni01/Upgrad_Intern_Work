package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@CrossOrigin(origins = "http://127.0.0.1:5500")

@RestController
@RequestMapping("/api")
public class ShiftController {

    private final ShiftManagementService shiftManagementService;

    @Autowired
    public ShiftController(ShiftManagementService shiftManagementService) {
        this.shiftManagementService = shiftManagementService;
    }

    @PostMapping("/shifts")
    public void createShift(@RequestBody Shift shift) {
        shiftManagementService.saveShift(shift);
    }

    @GetMapping("/shifts")
    public List<Shift> getAllShifts() {
        return shiftManagementService.getAllShifts();
    }

    @PutMapping("/shifts/{id}")
    public void updateShift(@PathVariable UUID id, @RequestBody Shift updatedShift) {
        Shift existingShift = shiftManagementService.getShiftById(id).orElse(null);
        if (existingShift != null) {
            // Update the existing shift with the new data
            existingShift.setName(updatedShift.getName());
            existingShift.setDateStart(updatedShift.getDateStart());
            existingShift.setDateEnd(updatedShift.getDateEnd());
            existingShift.setTimeStart(updatedShift.getTimeStart());
            existingShift.setTimeEnd(updatedShift.getTimeEnd());
            // Update the shift
            shiftManagementService.updateShift(existingShift);
        }
    }

    @DeleteMapping("/shifts/{id}")
    public void deleteShift(@PathVariable UUID id) {
        shiftManagementService.deleteShift(id);
    }
}

