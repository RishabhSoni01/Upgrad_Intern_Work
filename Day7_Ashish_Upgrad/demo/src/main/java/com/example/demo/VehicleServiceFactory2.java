package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceFactory2 extends VehicleService {

    public VehicleServiceFactory2(TyreService tyreService, SpeakerService speakerService) {
        super(tyreService, speakerService);
    }

    @Override
    public double calculateAdditionalCost() {
        return 0.05; // For example, 10% increase in tire cost
    }
}
