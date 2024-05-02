package com.example.springTwo;



import org.springframework.stereotype.Service;

@Service
public class VehicleServiceFactory2 extends VehicleService {

    public VehicleServiceFactory2(TyreService tyreService, SpeakerService speakerService) {
        super(tyreService, speakerService);
    }

    @Override
    public double calculateAdditionalCost() {
        return 0.05;
    }
}
