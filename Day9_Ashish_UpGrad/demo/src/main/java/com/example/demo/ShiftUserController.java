package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ShiftUserController {

    private final ShiftManagementService shiftManagementService;

    @Autowired
    public ShiftUserController(ShiftManagementService shiftManagementService) {
        this.shiftManagementService = shiftManagementService;
    }

    @PostMapping("/shift-users")
    public void createShiftUser(@RequestBody ShiftUser shiftUser) {
        shiftManagementService.saveShiftUser(shiftUser);
    }

    @GetMapping("/shift-users")
    public List<ShiftUser> getAllShiftUsers() {
        return shiftManagementService.getAllShiftUsers();
    }

    @DeleteMapping("/shift-users/{id}")
    public void deleteShiftUser(@PathVariable UUID id) {
        shiftManagementService.deleteShiftUser(id);
    }
}

