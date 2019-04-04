package com.christophermasse.daggerexample;

import android.app.Application;

import com.christophermasse.daggerexample.di.component.AppComponent;
import com.christophermasse.daggerexample.di.component.DaggerAppComponent;

public class App extends Application {

    AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder().build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

}
