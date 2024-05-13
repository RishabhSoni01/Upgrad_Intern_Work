package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class UserController {

    private final ShiftManagementService shiftManagementService;

    @Autowired
    public UserController(ShiftManagementService shiftManagementService) {
        this.shiftManagementService = shiftManagementService;
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User user) {
        shiftManagementService.saveUser(user);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return shiftManagementService.getAllUsers();
    }

    @PutMapping("/users/{id}")
    public void updateUser(@PathVariable UUID id, @RequestBody User updatedUser) {
        User existingUser = shiftManagementService.getUserById(id).orElse(null);
        if (existingUser != null) {
            // Update the existing user with the new data
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setLoggedIn(updatedUser.getLoggedIn());
            existingUser.setTimeZone(updatedUser.getTimeZone());
            // Update the user
            shiftManagementService.updateUser(existingUser);
        }
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable UUID id) {
        shiftManagementService.deleteUser(id);
    }
}

