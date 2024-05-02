package com.example.Java7.java7.model;



import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private double price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "speaker_id", referencedColumnName = "id")
    private Speaker speaker;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tyre_id", referencedColumnName = "id")
    private Tyre tyre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

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
}
