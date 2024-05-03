package org.example;

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

    public void setId(long l) {
    }

    public long getId() {
        return 0;
    }
}
