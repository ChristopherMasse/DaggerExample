package com.christophermasse.daggerexample.model;

import java.util.concurrent.ThreadLocalRandom;

import javax.inject.Inject;

public class Wheels {

    private int modelId;

    int numWheels;

    double tireSize;

    @Inject
    public Wheels() {
        this.modelId = ThreadLocalRandom.current().nextInt(1, 1000);
        this.numWheels = 4;
        this.tireSize = 36.5;
    }
}
