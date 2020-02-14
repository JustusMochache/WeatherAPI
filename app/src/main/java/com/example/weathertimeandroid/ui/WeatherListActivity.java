package com.example.weathertimeandroid.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.weathertimeandroid.R;
import com.example.weathertimeandroid.adapters.WeatherListAdapter;
import com.example.weathertimeandroid.models.WeatherSearchResponse;
import com.example.weathertimeandroid.service.WeatherService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class WeatherListActivity extends AppCompatActivity {


    public List<com.example.weathertimeandroid.models.List> mWeatherForecasts = new ArrayList<>();
    public static final String TAG = WeatherListActivity.class.getSimpleName();
    @BindView(R.id.recyclerView)
    RecyclerView mRecycleView;
    private WeatherListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        getWeather(location);
    }

    private void getWeather(String location) {
        final WeatherService weatherService = new WeatherService();
        weatherService.findForecast(location, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                 WeatherSearchResponse forecast = weatherService.processResults(response);
                mWeatherForecasts = forecast.getList();
                WeatherListActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter = new WeatherListAdapter(WeatherListActivity.this,mWeatherForecasts,forecast);
                        mRecycleView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(WeatherListActivity.this);
                        mRecycleView.setLayoutManager(layoutManager);
                        mRecycleView.setHasFixedSize(true);
                    }
                });
            }
        });
    }



}
