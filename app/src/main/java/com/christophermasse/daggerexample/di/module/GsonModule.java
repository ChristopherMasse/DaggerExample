package com.christophermasse.daggerexample.di.module;

import com.christophermasse.daggerexample.di.scope.PerApplication;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;

@Module
public class GsonModule {

    @Provides
    @PerApplication
    Gson gson(){
        return new GsonBuilder().serializeNulls().create();
    }
}
