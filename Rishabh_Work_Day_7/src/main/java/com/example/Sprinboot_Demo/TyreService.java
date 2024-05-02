package com.example.Sprinboot_Demo;
import com.example.Sprinboot_Demo.Tyre;
import org.springframework.stereotype.Service;

@Service
public class TyreService {

    public Tyre generateTyre(String brand) {
        double price;
        if (brand.equalsIgnoreCase("Bridgestone")) {
            price = 200;
        } else if (brand.equalsIgnoreCase("MRF")) {
            price = 180;
        } else {
            throw new IllegalArgumentException("Invalid tyre brand");
        }
        return new Tyre(brand, price);
    }
}