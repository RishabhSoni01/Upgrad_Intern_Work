package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Vehicle {
    private Tyre tyre;
    private Speaker speaker;
    private double price;

    @Autowired
    public Vehicle(Tyre tyre, Speaker speaker) {
        this.tyre = tyre;
        this.speaker = speaker;
        this.price = tyre.getPrice() + speaker.getPrice() + Math.random() * 1000;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "tyre=" + tyre +
                ", speaker=" + speaker +
                ", price=" + price +
                '}';
    }
}
