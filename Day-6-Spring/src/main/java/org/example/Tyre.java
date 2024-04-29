package org.example;

import org.springframework.stereotype.Component;

@Component
public class Tyre {
    private String brand;
    private double price;
    public Tyre() {}
    public Tyre(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Tyre{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
