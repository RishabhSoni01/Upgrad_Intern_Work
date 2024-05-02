package org.example;

import org.springframework.stereotype.Service;

@Service
public class SpeakerService {
    public Speaker generateSpeaker() {
        String[] brands = {"Sony", "Bose"};
        double[] prices = {100.0, 150.0};
        int randomIndex = (int) (Math.random() * brands.length);
        String brand = brands[randomIndex];
        double price = prices[randomIndex];
        return new Speaker(brand, price);
    }
}
