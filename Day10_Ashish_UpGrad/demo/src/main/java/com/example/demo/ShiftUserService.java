package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ShiftUserService {

    private final ShiftUserRepository shiftUserRepository;

    @Autowired
    public ShiftUserService(ShiftUserRepository shiftUserRepository) {
        this.shiftUserRepository = shiftUserRepository;
    }

    public List<ShiftUser> getAllShiftUsers() {
        return shiftUserRepository.findAll();
    }

    public Optional<ShiftUser> getShiftUserById(UUID id) {
        return shiftUserRepository.findById(id);
    }

    public ShiftUser saveShiftUser(ShiftUser shiftUser) {
        return shiftUserRepository.save(shiftUser);
    }

    public void deleteShiftUser(UUID id) {
        shiftUserRepository.deleteById(id);
    }

    public void deleteShiftUserByShiftEnd(UUID shiftUserId) {
    }

    // Add more methods as needed
}

