package org.example;
import org.springframework.stereotype.Component;
import java.util.Random;

@Component
public class SpeakerService {
    private String[] brands = {"Sony", "Bose"};
    private int[] prices = {200, 300};

    public Speaker getSpeaker() {
        Random random = new Random();
        int brandIndex = random.nextInt(brands.length);
        int price = prices[brandIndex];
        return new Speaker(brands[brandIndex], price);
    }
}