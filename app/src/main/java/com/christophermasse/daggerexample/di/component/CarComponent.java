package com.christophermasse.daggerexample.di.component;

import com.christophermasse.daggerexample.activity.DetailActivity;

import dagger.Component;

@Component
public interface CarComponent {

    // Method used to provide our dependencies to the activity
    void inject(DetailActivity activity);

}
