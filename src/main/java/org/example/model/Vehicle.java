package org.example.model;

import org.example.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Random;


public class Vehicle {
    private Speaker speaker;
    private Tyre tyre;
    private int price;

    @Autowired
    public Vehicle(SpeakerService speakerService, TyreService tyreService) {
        Random random = new Random();
        this.speaker = speakerService.generateRandomSpeaker();
        this.tyre = tyreService.generateTyre("Bridgestone", 300);
        this.price = this.speaker.getPrice() + this.tyre.getPrice() + random.nextInt(1000) + 100;
    }

//    public Vehicle(Speaker speaker, Tyre tyre, int price) {
//        this.speaker = speaker;
//        this.tyre = tyre;
//        this.price = price;
//    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    public Tyre getTyre() {
        return tyre;
    }

    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "speaker=" + speaker +
                ", tyre=" + tyre +
                ", price=" + price +
                '}';
    }
}
