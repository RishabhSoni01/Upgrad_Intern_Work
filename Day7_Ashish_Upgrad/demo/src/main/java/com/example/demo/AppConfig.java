package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {
    @Bean
    @Profile("factory1")
    public VehicleService vehicleServiceFactory1(TyreService tyreService, SpeakerService speakerService) {
        return new VehicleServiceFactory1(tyreService, speakerService);
    }

    @Bean
    @Profile("factory2")
    public VehicleService vehicleServiceFactory2(TyreService tyreService, SpeakerService speakerService) {
        return new VehicleServiceFactory2(tyreService, speakerService);
    }
}
