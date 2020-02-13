package com.example.weathertimeandroid.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.weathertimeandroid.R;

public class ForecastMasterViewHolder extends RecyclerView.ViewHolder {

    TextView day;
    TextView low;
    TextView high;
    ImageView icon;

    public ForecastMasterViewHolder(View itemView) {
        super(itemView);

        day = (TextView) itemView.findViewById(R.id.tv_weekly_forecast_day);
        low = (TextView) itemView.findViewById(R.id.tv_weekly_forecast_low);
        high = (TextView) itemView.findViewById(R.id.tv_weekly_forecast_high);
        icon = (ImageView) itemView.findViewById(R.id.weather_icon_item);
    }


}
