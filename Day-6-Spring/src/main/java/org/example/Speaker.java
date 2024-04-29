package org.example;

import org.springframework.stereotype.Component;

@Component
public class Speaker {
    private String brand;
    private double price;

    public Speaker() {}

    public Speaker(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Speaker{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
