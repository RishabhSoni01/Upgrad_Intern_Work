package org.example;

public class Vehicle {
    private String name;
    private Speaker speaker;
    private Tyre tyre;
    private double price;

    public Vehicle(String name, double price, Speaker speaker, Tyre tyre) {
        this.name=name;
        this.price = price;
        this.speaker = speaker;
        this.tyre = tyre;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price + speaker.getPrice() + tyre.getPrice();
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public Tyre getTyre() {
        return tyre;
    }
}
