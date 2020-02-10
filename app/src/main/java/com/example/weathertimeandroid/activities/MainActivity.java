package com.example.weathertimeandroid.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.weathertimeandroid.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // This app doesn't use the action bar, so it is being hidden.
        getSupportActionBar().hide();

        // Setup the content view.
        setContentView(R.layout.activity_main);

        // Since this is just a blank activity, we must push ForecastMasterFragment onto the content_frame.
        pushToFragmentManager(getFragmentManager(), R.id.content_frame, new ForecastMasterFragment(), false);
    }
}
