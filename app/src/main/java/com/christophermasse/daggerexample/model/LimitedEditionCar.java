package com.christophermasse.daggerexample.model;

import com.christophermasse.daggerexample.di.scope.PerApplication;

import java.util.concurrent.ThreadLocalRandom;

import javax.inject.Inject;


/**
 * By scoping to {@link PerApplication} we create only one instance of the car to use throughout the app
 */

@PerApplication
public class LimitedEditionCar {

    private int modelId;

    private GasMotor motor;

    private Wheels wheels;

    @Inject
    public LimitedEditionCar(GasMotor motor, Wheels wheels) {
        this.modelId = ThreadLocalRandom.current().nextInt(1, 1000);
        this.motor = motor;
        this.wheels = wheels;
    }

}
