package com.example.Sprinboot_Demo;
import org.springframework.stereotype.Service;
import com.example.Sprinboot_Demo.Speaker;
@Service
public class SpeakerService {

    public Speaker generateSpeaker(String brand) {
        double price;
        if (brand.equalsIgnoreCase("Sony")) {
            price = 100; // Sample price for Sony
        } else if (brand.equalsIgnoreCase("Bose")) {
            price = 150; // Sample price for Bose
        } else {
            throw new IllegalArgumentException("Invalid speaker brand");
        }
        return new Speaker(brand, price);
    }
}