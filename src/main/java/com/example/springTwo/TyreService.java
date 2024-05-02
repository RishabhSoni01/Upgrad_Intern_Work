package com.example.springTwo;

import org.springframework.stereotype.Service;

@Service
public class TyreService {
    public Tyre generateTyre(String brand) {
        double price;
        if (brand.equalsIgnoreCase("Bridgestone")) {
            price = 100;
        } else if (brand.equalsIgnoreCase("MRF")) {
            price = 150;
        } else {
            throw new IllegalArgumentException("Invalid tyre brand");
        }
        return new Tyre(brand, price);
    }
}
