package com.christophermasse.daggerexample.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.christophermasse.daggerexample.R;
import com.christophermasse.daggerexample.di.component.DaggerCarComponent;
import com.christophermasse.daggerexample.model.Car;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = DetailActivity.class.getSimpleName();

    @Inject
    Car car;

    TextView wTextView;

    Button wButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        wTextView = findViewById(R.id.textView);

        wButton = findViewById(R.id.button);

//         Tell Dagger to provide dependencies to this activity
        DaggerCarComponent.builder().build()
                .inject(this);

        //Show the details of the car;
        Gson gson = new GsonBuilder().serializeNulls().create(); //this is also injected, skip
        String carObjectInfo = gson.toJson(car);
        wTextView.setText(carObjectInfo);



        //Log the hashcodes of the objects
        String gsonLog = "Gson instance: " + System.identityHashCode(gson);
        String carLog = "Car instance: " + System.identityHashCode(car);
        Log.d(TAG, gsonLog);
        Log.d(TAG, carLog);



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

}
