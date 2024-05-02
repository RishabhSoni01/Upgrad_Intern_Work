package com.example.springTwo;

import org.springframework.stereotype.Service;

@Service
public class VehicleServiceFactory1 extends VehicleService {

    public VehicleServiceFactory1(TyreService tyreService, SpeakerService speakerService) {
        super(tyreService, speakerService);
    }

    @Override
    public double calculateAdditionalCost() {
        return 0.10; // For example, 10% increase in tire cost
    }
}
