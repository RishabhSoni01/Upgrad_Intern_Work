package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ShiftTypeService {

    private final ShiftTypeRepository shiftTypeRepository;

    @Autowired
    public ShiftTypeService(ShiftTypeRepository shiftTypeRepository) {
        this.shiftTypeRepository = shiftTypeRepository;
    }

    public List<ShiftType> getAllShiftTypes() {
        return shiftTypeRepository.findAll();
    }

    public Optional<ShiftType> getShiftTypeById(UUID id) {
        return shiftTypeRepository.findById(id);
    }

    public ShiftType saveShiftType(ShiftType shiftType) {
        return shiftTypeRepository.save(shiftType);
    }

    public void deleteShiftType(UUID id) {
        shiftTypeRepository.deleteById(id);
    }

    // Add more methods as needed
}
