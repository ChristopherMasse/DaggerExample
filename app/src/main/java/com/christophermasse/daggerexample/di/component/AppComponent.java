package com.christophermasse.daggerexample.di.component;

import com.christophermasse.daggerexample.di.module.AppModule;
import com.christophermasse.daggerexample.di.module.GsonModule;
import com.christophermasse.daggerexample.di.scope.PerApplication;
import com.christophermasse.daggerexample.model.LimitedEditionCar;
import com.google.gson.Gson;

import dagger.Component;

@PerApplication
@Component(modules = {AppModule.class, GsonModule.class})
public interface AppComponent {

    LimitedEditionCar car();

    Gson gson();

}
