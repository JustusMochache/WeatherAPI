
package com.example.weathertimeandroid.models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;


@Parcel(Parcel.Serialization.BEAN)
public class Clouds implements Serializable
{

    @SerializedName("all")
    @Expose
    private Integer all;
    private final static long serialVersionUID = 240788615692178390L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Clouds() {
    }

    /**
     * 
     * @param all
     */
    public Clouds(Integer all) {
        super();
        this.all = all;
    }

    public Integer getAll() {
        return all;
    }

    public void setAll(Integer all) {
        this.all = all;
    }

}
