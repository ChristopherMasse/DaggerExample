package com.christophermasse.daggerexample.di.component;

import com.christophermasse.daggerexample.activity.DetailActivity;
import com.christophermasse.daggerexample.di.scope.PerActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = {AppComponent.class})
public interface CarComponent {

    void inject(DetailActivity detailActivity);

}
