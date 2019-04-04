package com.christophermasse.daggerexample.model;

import java.util.concurrent.ThreadLocalRandom;

import javax.inject.Inject;

public class GasMotor {

    private int modelId;

    private GasTank gasTank;


    @Inject
    public GasMotor(GasTank gasTank) {
        this.modelId = ThreadLocalRandom.current().nextInt(1, 1000);
        this.gasTank = gasTank;
    }
}
