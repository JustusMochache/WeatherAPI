package com.example.weathertimeandroid.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.weathertimeandroid.R;
import com.example.weathertimeandroid.adapters.WeatherPagerAdapter;
import com.example.weathertimeandroid.models.City;
import com.example.weathertimeandroid.models.WeatherSearchResponse;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherDetailActivity extends AppCompatActivity {


    @BindView(R.id.viewPager) ViewPager mViewpager;
    private WeatherPagerAdapter adapterViewpager;
    City mCity;
    WeatherSearchResponse mForecast;
    List<com.example.weathertimeandroid.models.List> mWeatherForecasts =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_detail);
        ButterKnife.bind(this);

        mForecast = Parcels.unwrap(getIntent().getParcelableExtra("forecast"));
        mCity = Parcels.unwrap(getIntent().getParcelableExtra("city"));
        mWeatherForecasts = Parcels.unwrap(getIntent().getParcelableExtra("forecastLists"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewpager = new WeatherPagerAdapter(getSupportFragmentManager(), mWeatherForecasts, mCity, mForecast);
        mViewpager.setAdapter(adapterViewpager);
        mViewpager.setCurrentItem(startingPosition);
    }

//    @BindView(R.id.viewPager)
//    ViewPager mViewpager;
//    private WeatherPagerAdapter adapterViewpager;
//    City mCity;
//    WeatherSearchResponse mForecast;
//    List<com.example.weathertimeandroid.models.List> mWeatherForecasts =new ArrayList<>();
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_weather_detail);
//        ButterKnife.bind(this);
//
//        mForecast= Parcels.unwrap(getIntent().getParcelableExtra("forecast"));
//        mCity = Parcels.unwrap(getIntent().getParcelableExtra("city"));
//        mWeatherForecasts = Parcels.unwrap(getIntent().getParcelableExtra("Lists"));
//        int startingPosition = getIntent().getIntExtra("position", 0);
//
//        adapterViewpager = new WeatherPagerAdapter(getSupportFragmentManager(), mWeatherForecasts, mCity, mForecast);
//        mViewpager.setAdapter(adapterViewpager);
//        mViewpager.setCurrentItem(startingPosition);
//    }
}
