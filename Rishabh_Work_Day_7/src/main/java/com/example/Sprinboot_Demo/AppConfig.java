package com.example.Sprinboot_Demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {
    @Bean
    @Profile("factory1")
    public VehicleService Factory1VehicleService(TyreService tyreService, SpeakerService speakerService) {
        return new Factory1VehicleService(tyreService, speakerService);
    }

    @Bean
    @Profile("factory2")
    public VehicleService Factory2VehicleService(TyreService tyreService, SpeakerService speakerService) {
        return new Factory2VehicleService(tyreService, speakerService);
    }
}