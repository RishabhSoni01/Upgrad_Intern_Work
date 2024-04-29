package org.example.service;

import org.example.model.Speaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SpeakerService {
    private final String[] brands = {"Sony", "Bose"};
    private final int[] prices = {200, 300};

    @Autowired
    private Speaker speaker; // Autowire Speaker bean

    public Speaker generateRandomSpeaker() {
        Random random = new Random();
        int index = random.nextInt(brands.length);
        speaker.setBrand(brands[index]); // Set brand
        speaker.setPrice(prices[index]); // Set price
        return speaker;
    }
}