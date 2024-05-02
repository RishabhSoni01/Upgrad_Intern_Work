package org.example;

import org.springframework.stereotype.Service;

@Service
public class TyreService {
    public Tyre generateTyre() {
        String[] brands = {"Bridgestone", "MRF"};
        double[] prices = {200.0, 180.0};
        int randomIndex = (int) (Math.random() * brands.length);
        String brand = brands[randomIndex];
        double price = prices[randomIndex];
        return new Tyre(brand, price);
    }
}
