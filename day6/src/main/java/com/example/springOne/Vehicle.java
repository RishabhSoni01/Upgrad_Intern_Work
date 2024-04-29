package com.example.springOne;

public class Vehicle {

    private Speaker speaker;
    private Tyre tyre;
    private double priceTag;

    public Vehicle(double priceTag, Speaker speaker, Tyre tyre) {
        this.speaker = speaker;
        this.tyre = tyre;
        this.priceTag=priceTag;
    }
    public double getPrice() {
        return priceTag + speaker.getPrice() + tyre.getPrice();
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public Tyre getTyre() {
        return tyre;
    }
}
