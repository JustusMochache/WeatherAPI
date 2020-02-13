package com.example.weathertimeandroid.constants;

import com.example.weathertimeandroid.BuildConfig;

public class Constants {

    public static final String ACCESS_KEY= BuildConfig.ACCESS_KEY;
    public static final String ACCESS_BASE_URL = "http://api.openweathermap.org/data/2.5";
    public static final String ACCESS_LOCATION_QUERY_PARAMETER = "q";
    public static final String UNITS = "units";
    public static final String FORMAT = "metric";
    public static final String API_KEY_PARAM = "appid";
    public static final String WEATHER_ICON_BASEURL = "http://openweathermap.org/img/w/";
    public static final String ICON_EXTENSION = ".png";
    public static final String PREFERENCES_LOCATION_KEY = "location";
    public static final String FIREBASE_CHILD_SEARCHED_LOCATION = "mSearchedLocation";
    public static final String FIREBASE_CHILD_FORECAST = "timeBasedForecast";
}
