package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ShiftService {

    private final ShiftRepository shiftRepository;

    @Autowired
    public ShiftService(ShiftRepository shiftRepository) {
        this.shiftRepository = shiftRepository;
    }

    public List<Shift> getAllShifts() {
        return shiftRepository.findAll();
    }

    public Optional<Shift> getShiftById(UUID id) {
        return shiftRepository.findById(id);
    }

    public Shift saveShift(Shift shift) {
        return shiftRepository.save(shift);
    }

    public void deleteShift(UUID id) {
        shiftRepository.deleteById(id);
    }

    public List<Shift> findTop3Shifts() {
        return List.of();
    }

    public List<Shift> findTop3ShiftsByDateRange(String date, String date1) {
        return List.of();
    }

    // Add more methods as needed
}

