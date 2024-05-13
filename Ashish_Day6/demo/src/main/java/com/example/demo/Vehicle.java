package com.example.demo;

public class Vehicle {

    private double price;
    private Speaker speaker;
    private Tyre tyre;

    public Vehicle(double price, Speaker speaker, Tyre tyre) {
        this.price = price;
        this.speaker = speaker;
        this.tyre = tyre;
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