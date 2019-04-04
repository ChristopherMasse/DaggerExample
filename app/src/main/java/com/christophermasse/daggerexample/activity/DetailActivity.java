package com.christophermasse.daggerexample.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.christophermasse.daggerexample.App;
import com.christophermasse.daggerexample.R;
import com.christophermasse.daggerexample.di.component.CarComponent;
import com.christophermasse.daggerexample.di.component.DaggerCarComponent;
import com.christophermasse.daggerexample.model.Car;
import com.christophermasse.daggerexample.model.LimitedEditionCar;
import com.christophermasse.daggerexample.model.UnscopedCar;
import com.google.gson.Gson;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = DetailActivity.class.getSimpleName();

    @Inject
    UnscopedCar mCar1; // will vary per activity



    @Inject
    Car mCar2; // car2 and car3 will be the same for a single activity

    @Inject
    Car mCar3; // car2 and car3 will be the same for a single activity


    @Inject
    LimitedEditionCar mCar4; // will be the same for each run of the application

    @Inject
    Gson mGson;

    TextView wTextView;

    Button wButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        wTextView = findViewById(R.id.textView);

        wButton = findViewById(R.id.button);


        performDaggerInjection();

        showCarDetails();

        logHashCodes();

        wButton.setText("Open another activity");
        // Open another activity on Button Click
        wButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity.this, DetailActivity.class);
                DetailActivity.this.startActivity(intent);
            }
        });
    }

    private void performDaggerInjection() {
        CarComponent carComponent = DaggerCarComponent.builder()
                .appComponent(((App)(getApplication())).getAppComponent()) // Get dependency for gson &
                .build();
        carComponent.inject(this);
    }

    private void showCarDetails() {
        //Show the details of the mCar1;
        String carObjectInfo = mGson.toJson(mCar1)+ "\n \n"
                + mGson.toJson(mCar2) + "\n \n"
                + mGson.toJson(mCar3) + "\n \n"
                + mGson.toJson(mCar4) + "\n \n";
        wTextView.setText(carObjectInfo);
    }


    private void logHashCodes() {
        //Log the hashcodes of the objects

        String gsonLog = "mGson instance: " + System.identityHashCode(mGson);
        String carLog1 = "Car1 instance: " + System.identityHashCode(mCar1);
        String carLog2 = "Car2 instance: " + System.identityHashCode(mCar2);
        String carLog3 = "Car3 instance: " + System.identityHashCode(mCar3);
        String carLog4 = "Car4 instance: " + System.identityHashCode(mCar4);

        Log.d(TAG, gsonLog);
        Log.d(TAG, carLog1);
        Log.d(TAG, carLog2);
        Log.d(TAG, carLog3);
        Log.d(TAG, carLog4);
    }

}
