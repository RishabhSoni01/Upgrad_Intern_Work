package com.example.Sprinboot_Demo;

import com.example.Sprinboot_Demo.SpeakerService;
import com.example.Sprinboot_Demo.TyreService;
import com.example.Sprinboot_Demo.VehicleService;
import org.springframework.stereotype.Service;

@Service
public class Factory1VehicleService extends VehicleService {

    public Factory1VehicleService(TyreService tyreService, SpeakerService speakerService) {
        super(tyreService, speakerService);
    }

    @Override
    public double calculateAdditionalCost() {
        return 0.10; // For example, 10% increase in tire cost
    }
}