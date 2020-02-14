package com.example.weathertimeandroid.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.weathertimeandroid.R;
import com.example.weathertimeandroid.models.WeatherSearchResponse;
import com.example.weathertimeandroid.ui.WeatherDetailActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherListAdapter extends RecyclerView.Adapter<WeatherListAdapter.WeatherViewHolder> {
    private List<com.example.weathertimeandroid.models.List> mWeatherForecasts = new ArrayList<>();
    private WeatherSearchResponse mForecast;

    private Context mContext;

    public WeatherListAdapter(Context context, List<com.example.weathertimeandroid.models.List> weatherForecasts, WeatherSearchResponse forecast){
        mContext = context;
        mWeatherForecasts = weatherForecasts;
        mForecast = forecast;
    }

    @Override
    public WeatherListAdapter.WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate( R.layout.weather_list_item, parent, false);
        WeatherViewHolder viewHolder = new WeatherViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(WeatherListAdapter.WeatherViewHolder holder, int position){
        holder.bindWeatherForecast(mWeatherForecasts.get(position));
    }

    @Override
    public int getItemCount(){
        return mWeatherForecasts.size();
    }

    public class WeatherViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.weatherImageView)
        ImageView mWeatherImageView;
        @BindView(R.id.mainWeatherTextView) TextView mMainWeatherTextView;
        @BindView(R.id.temperatureTextView) TextView mMaintemparatureTextView;
        @BindView(R.id.timeTextView)
        TextView mTimeTextView;

        private Context mContext;

        public WeatherViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        public void bindWeatherForecast(com.example.weathertimeandroid.models.List forecastList){
            //Picasso.get().load(forecastList.g()).into(mWeatherImageView);
            mMainWeatherTextView.setText(forecastList.getWeather().get(0).getMain());
            mMaintemparatureTextView.setText("Average Temperatures of: "+forecastList.toString());
            mTimeTextView.setText(forecastList.getDt());
        }

        @Override
        public void onClick(View v){
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, WeatherDetailActivity.class);
            intent.putExtra("forecast", Parcels.wrap(mForecast));
            intent.putExtra("position", itemPosition);
            intent.putExtra("forecastLists", Parcels.wrap(mWeatherForecasts));
            intent.putExtra("city", Parcels.wrap(mForecast.getCity()));
            mContext.startActivity(intent);
        }
    }
}
