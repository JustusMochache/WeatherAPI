package com.example.weathertimeandroid.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weathertimeandroid.R;
import com.example.weathertimeandroid.models.City;
import com.example.weathertimeandroid.models.List;
import com.example.weathertimeandroid.models.WeatherSearchResponse;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;


public class WeatherDetailFragment extends Fragment implements View.OnClickListener{


    @BindView(R.id.fragmentTemperatureTextView)
    TextView mFragmentTemparatureTextView;
    @BindView(R.id.iconImageView) ImageView mIconView;
    @BindView(R.id.descriptionTextView) TextView mDescriptionTextView;
    @BindView(R.id.cityNameTextView) TextView mCityNameTextView;
    @BindView(R.id.populationTextView) TextView mPopulationTextView;
    @BindView(R.id.minimumTemparatureTextView) TextView mMinimumTemperature;
    @BindView(R.id.maximumTemparatureTextView) TextView mMaximumTemperatureTextView;
    @BindView(R.id.windSpeedTextView) TextView mWindSpeedTextView;
    @BindView(R.id.coordinatesTextView) TextView mLocationCoordinates;
    @BindView(R.id.button)
    Button mSaveButton;

    private WeatherSearchResponse forecast;
    private List weatherForecast;
    private City city;


    public static androidx.fragment.app.Fragment newInstance(List mForecastList, City mCity, WeatherSearchResponse mForecast){
        WeatherDetailFragment weatherDetailFragment = new WeatherDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("forecast", Parcels.wrap(mForecast));
        args.putParcelable("forecastList", Parcels.wrap(mForecastList));
        args.putParcelable("city", Parcels.wrap(mCity));
        weatherDetailFragment.setArguments(args);
        return weatherDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        weatherForecast = Parcels.unwrap(getArguments().getParcelable("forecastList"));
        city = Parcels.unwrap(getArguments().getParcelable("city"));
        forecast= Parcels.unwrap(getArguments().getParcelable("forecast"));
    }


    public WeatherDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather_detail, container, false);
        ButterKnife.bind(this, view);


        Picasso.get().load(weatherForecast.getWeather().get(0).getIcon()).into(mIconView);
        mLocationCoordinates.setText(city.getCoord().toString());
        mFragmentTemparatureTextView.setText(Double.toString(weatherForecast.getMain().getTemp()));
        mDescriptionTextView.setText(weatherForecast.getWeather().get(0).getDescription());
        mCityNameTextView.setText(city.getName());
        mPopulationTextView.setText(city.getCountry());
        mMinimumTemperature.setText(Double.toString(weatherForecast.getMain().getTempMin()));
        mMaximumTemperatureTextView.setText(Double.toString(weatherForecast.getMain().getTempMax()));
        mWindSpeedTextView.setText(Double.toString(weatherForecast.getWind().getSpeed()));
        mLocationCoordinates.setOnClickListener(this);
        mSaveButton.setOnClickListener(this);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View v){
        switch (v.getId()) {

            case R.id.coordinatesTextView :
                Intent webMapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:" + city.getCoord().getLat() + "," + city.getCoord().getLon() + "?q=(" + city.getName() + ")"));
                startActivity(webMapIntent);
                break;


        }
    }

}

