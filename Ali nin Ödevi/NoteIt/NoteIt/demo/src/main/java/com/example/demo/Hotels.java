package com.example.demo;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class Hotels implements Serializable {

    @Id
    private String id;
    private String name;
    private int pricePerNight;
    private String address;
    private int rating;
    public String token;

    public String getName() {
        return name;
    }

    public int getPricePerNight() {
        return pricePerNight;
    }

    public String getAddress() {
        return address;
    }

    public int getRating() {
        return rating;
    }

    public Hotels(String name, int pricePerNight, String address, int rating) {
        this.name = name;
        this.pricePerNight = pricePerNight;
        this.address = address;
        this.rating = rating;
    }
}
