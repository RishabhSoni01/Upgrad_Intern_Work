package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ShiftTypeController {

    private final ShiftManagementService shiftManagementService;

    @Autowired
    public ShiftTypeController(ShiftManagementService shiftManagementService) {
        this.shiftManagementService = shiftManagementService;
    }

    @PostMapping("/shift-types")
    public void createShiftType(@RequestBody ShiftType shiftType) {
        shiftManagementService.saveShiftType(shiftType);
    }

    @GetMapping("/shift-types")
    public List<ShiftType> getAllShiftTypes() {
        return shiftManagementService.getAllShiftTypes();
    }

    @PutMapping("/shift-types/{id}")
    public void updateShiftType(@PathVariable UUID id, @RequestBody String newDescription) {
        shiftManagementService.updateShiftTypeDescription(id, newDescription);
    }

    @DeleteMapping("/shift-types/{id}")
    public void deleteShiftType(@PathVariable UUID id) {
        shiftManagementService.deleteShiftType(id);
    }
}

