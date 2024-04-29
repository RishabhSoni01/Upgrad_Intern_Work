package org.example;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class TyreService {
    private String[] brands = {"Bridgestone", "MRF"};
    private int[] prices = {500, 600};

    public Tyre getTyre() {
        Random random = new Random();
        int brandIndex = random.nextInt(brands.length);
        int price = prices[brandIndex];
        return new Tyre(brands[brandIndex], price);
    }
}