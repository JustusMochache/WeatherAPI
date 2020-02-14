package com.example.weathertimeandroid.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weathertimeandroid.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @BindView(R.id.locationEditText)
    EditText mLocationEditText;
    @BindView(R.id.appName)
    TextView mAppName;
    @BindView(R.id.checkForeCast)
    Button mCheckForecast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getSupportActionBar().hide();

        mCheckForecast.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mCheckForecast) {
            Intent intent = new Intent(MainActivity.this, WeatherListActivity.class);
            String mLocation = mLocationEditText.getText().toString();
            Toast.makeText(MainActivity.this, "Location Weather", Toast.LENGTH_LONG).show();
//            if(!(mLocation=="")){
//                addToSharedPreferences(mLocation);
//            }
            intent.putExtra("location", mLocation);
            startActivity(intent);
        }


    }
}
