package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public VehicleService vehicleService() {
        return new VehicleService();
    }

    @Bean
    public TyreService tyreService() {
        return new TyreService();
    }

    @Bean
    public SpeakerService speakerService() {
        return new SpeakerService();
    }
}