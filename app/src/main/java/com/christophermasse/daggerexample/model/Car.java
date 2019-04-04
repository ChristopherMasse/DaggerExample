package com.christophermasse.daggerexample.model;

import java.util.concurrent.ThreadLocalRandom;

import javax.inject.Inject;

public class Car {

    private int modelId;

    private GasMotor motor;

    private Wheels wheels;

    @Inject
    public Car(GasMotor motor, Wheels wheels) {
        this.modelId = ThreadLocalRandom.current().nextInt(1, 1000);
        this.motor = motor;
        this.wheels = wheels;
    }
}
