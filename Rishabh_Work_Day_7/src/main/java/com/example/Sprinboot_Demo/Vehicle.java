package com.example.Sprinboot_Demo;

import com.example.Sprinboot_Demo.Speaker;
import com.example.Sprinboot_Demo.Tyre;

public class Vehicle {

    private double price;
    private Speaker speaker;
    private Tyre tyre;



    public double getPrice() {
        return price + speaker.getPrice() + tyre.getPrice();
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public Tyre getTyre() {
        return tyre;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }
}