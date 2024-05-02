package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
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