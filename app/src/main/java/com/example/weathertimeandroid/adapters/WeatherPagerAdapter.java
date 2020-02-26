package com.example.weathertimeandroid.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.weathertimeandroid.models.City;
import com.example.weathertimeandroid.models.WeatherSearchResponse;
import com.example.weathertimeandroid.ui.WeatherDetailFragment;

import java.util.List;

public class WeatherPagerAdapter extends FragmentPagerAdapter {

    private List<com.example.weathertimeandroid.models.List> mWeatherForecasts;
    private City mCity;
    private WeatherSearchResponse mForecast;

    public WeatherPagerAdapter(FragmentManager fm, List<com.example.weathertimeandroid.models.List> weatherForecast, City city, WeatherSearchResponse forecast){
        super(fm);
        mWeatherForecasts = weatherForecast;
        mCity = city;
        mForecast = forecast;
    }

    @Override
    public Fragment getItem(int position){
        return WeatherDetailFragment.newInstance(mWeatherForecasts, mCity, mForecast);
    }

    @Override
    public int getCount(){
        return mWeatherForecasts.size();
    }

    @Override
    public CharSequence getPageTitle(int position){
        return mWeatherForecasts.get(position).toString();
    }



}
