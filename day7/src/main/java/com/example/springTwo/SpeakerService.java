package com.example.springTwo;

import org.springframework.stereotype.Service;

@Service
public class SpeakerService {
    public Speaker generateSpeaker(String brand) {
        double price;
        if (brand.equalsIgnoreCase("Sony")) {
            price = 100;
        } else if (brand.equalsIgnoreCase("Bose")) {
            price = 250;
        } else {
            throw new IllegalArgumentException("Invalid speaker brand");
        }
        return new Speaker(brand, price);
    }
}
