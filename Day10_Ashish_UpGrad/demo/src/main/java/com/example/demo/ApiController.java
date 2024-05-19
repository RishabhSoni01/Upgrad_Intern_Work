package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final ShiftTypeService shiftTypeService;
    private final ShiftService shiftService;
    private final UserService userService;
    private final ShiftUserService shiftUserService;

    @Autowired
    public ApiController(ShiftTypeService shiftTypeService, ShiftService shiftService, UserService userService, ShiftUserService shiftUserService) {
        this.shiftTypeService = shiftTypeService;
        this.shiftService = shiftService;
        this.userService = userService;
        this.shiftUserService = shiftUserService;
    }


    @PostMapping("/shift-types")
    public ResponseEntity<ShiftType> saveShiftType(@RequestBody ShiftType shiftType) {
        ShiftType savedShiftType = shiftTypeService.saveShiftType(shiftType);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedShiftType);
    }

    @PostMapping("/shifts")
    public ResponseEntity<Shift> saveShift(@RequestBody Shift shift) {
        Shift savedShift = shiftService.saveShift(shift);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedShift);
    }

    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @PostMapping("/shift-users")
    public ResponseEntity<ShiftUser> saveShiftUser(@RequestBody ShiftUser shiftUser) {
        ShiftUser savedShiftUser = shiftUserService.saveShiftUser(shiftUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedShiftUser);
    }


    @GetMapping("/users")
    public ResponseEntity<Page<User>> findAllUsers(@RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "50") int size) {
        Page<User> users = (Page<User>) userService.findAllUsers(PageRequest.of(page, size));
        return ResponseEntity.ok(users);
    }


    @DeleteMapping("/shift-users/{id}")
    public ResponseEntity<?> deleteShiftUser(@PathVariable UUID id) {
        try {
            shiftUserService.deleteShiftUser(id);
            return ResponseEntity.ok().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/top-shifts")
    public ResponseEntity<List<Shift>> getTopShifts() {
        List<Shift> topShifts = shiftService.findTop3ShiftsByDateRange("2023-01-01", "2023-01-25");
        if (topShifts.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(topShifts);
    }

    // 5. Update user details using native JPA query
    @PutMapping("/users/{userId}")
    public ResponseEntity<User> updateUserDetails(@PathVariable UUID userId, @RequestBody User userDetails) {
        try {
            User updatedUser = userService.updateUserDetails(userId, userDetails);
            return ResponseEntity.ok(updatedUser);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
