package com.christophermasse.daggerexample.model;

import java.util.concurrent.ThreadLocalRandom;

import javax.inject.Inject;

public class GasTank {

    private int modelId;

    private final double capacity; //gallons

    private double gallonsRemaining;

    @Inject
    public GasTank() {
        this.modelId = ThreadLocalRandom.current().nextInt(1, 1000);
        this.capacity = 12;
        this.gallonsRemaining = 8;
    }

    public double getGallonsRemaining() {
        return gallonsRemaining;
    }

    public void setGallonsRemaining(double gallonsRemaining) {
        this.gallonsRemaining = Math.min(gallonsRemaining, capacity);
    }
}
