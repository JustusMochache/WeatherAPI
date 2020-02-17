
package com.example.weathertimeandroid.models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;


@Parcel
public class WeatherSearchResponse implements Serializable
{

    @SerializedName("cod")
    @Expose
    private String cod;
    @SerializedName("message")
    @Expose
    private Double message;
    @SerializedName("cnt")
    @Expose
    private Double cnt;
    @SerializedName("list")
    @Expose
    private java.util.List<com.example.weathertimeandroid.models.List> list = null;
    @SerializedName("city")
    @Expose
    private City city;
    private final static long serialVersionUID = 5062164582072266725L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public WeatherSearchResponse() {
    }

    /**
     * 
     * @param city
     * @param cnt
     * @param cod
     * @param message
     * @param list
     */
    public WeatherSearchResponse(String cod, Double message, Double cnt, java.util.List<com.example.weathertimeandroid.models.List> list, City city) {
        super();
        this.cod = cod;
        this.message = message;
        this.cnt = cnt;
        this.list = list;
        this.city = city;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Double getMessage() {
        return message;
    }

    public void setMessage(Double message) {
        this.message = message;
    }

    public Double getCnt() {
        return cnt;
    }

    public void setCnt(Double cnt) {
        this.cnt = cnt;
    }

    public java.util.List<com.example.weathertimeandroid.models.List> getList() {
        return list;
    }

    public void setList(java.util.List<com.example.weathertimeandroid.models.List> list) {
        this.list = list;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

}
